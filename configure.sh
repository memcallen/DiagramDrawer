confirm() {
    # call with a prompt string or use a default
    read -r -p "${1:-Are you sure? [y/N]} " response
    case "$response" in
        [yY][eE][sS]|[yY]) 
            true
            ;;
        *)
            false
            ;;
    esac
}

if [ -e "$1" ]
then
	cd "$1"
fi

confirm "Download CommonUtils-latest, JOML-latest, MTJ-latest to $(pwd)?" || exit

echo -e "\nDownloading CommonUtils-latest...\n================="

git clone https://github.com/memcallen/CommonUtils.git

echo -e "\nDownloading JOML-latest...\n================"

git clone https://github.com/JOML-CI/JOML.git

echo -e "\nDownloading MTJ-latest...\n================"

git clone https://github.com/fommil/matrix-toolkits-java.git
