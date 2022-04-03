for i in {1..10}
do
    touch _20_flyweight/big_chars/big${i}.txt
    cat _20_flyweight/big_chars/big0.txt > _20_flyweight/big_chars/big${i}.txt
done