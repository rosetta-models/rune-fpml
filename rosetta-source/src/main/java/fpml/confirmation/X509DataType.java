package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.X509DataType;
import fpml.confirmation.X509DataType.X509DataTypeBuilder;
import fpml.confirmation.X509DataType.X509DataTypeBuilderImpl;
import fpml.confirmation.X509DataType.X509DataTypeImpl;
import fpml.confirmation.X509DataTypeSequence;
import fpml.confirmation.meta.X509DataTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="X509DataType", builder=X509DataType.X509DataTypeBuilderImpl.class, version="${project.version}")
public interface X509DataType extends RosettaModelObject {

	X509DataTypeMeta metaData = new X509DataTypeMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends X509DataTypeSequence> getX509DataTypeSequence();

	/*********************** Build Methods  ***********************/
	X509DataType build();
	
	X509DataType.X509DataTypeBuilder toBuilder();
	
	static X509DataType.X509DataTypeBuilder builder() {
		return new X509DataType.X509DataTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends X509DataType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends X509DataType> getType() {
		return X509DataType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("x509DataTypeSequence"), processor, X509DataTypeSequence.class, getX509DataTypeSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface X509DataTypeBuilder extends X509DataType, RosettaModelObjectBuilder {
		X509DataTypeSequence.X509DataTypeSequenceBuilder getOrCreateX509DataTypeSequence(int _index);
		List<? extends X509DataTypeSequence.X509DataTypeSequenceBuilder> getX509DataTypeSequence();
		X509DataType.X509DataTypeBuilder addX509DataTypeSequence(X509DataTypeSequence x509DataTypeSequence0);
		X509DataType.X509DataTypeBuilder addX509DataTypeSequence(X509DataTypeSequence x509DataTypeSequence1, int _idx);
		X509DataType.X509DataTypeBuilder addX509DataTypeSequence(List<? extends X509DataTypeSequence> x509DataTypeSequence2);
		X509DataType.X509DataTypeBuilder setX509DataTypeSequence(List<? extends X509DataTypeSequence> x509DataTypeSequence3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("x509DataTypeSequence"), processor, X509DataTypeSequence.X509DataTypeSequenceBuilder.class, getX509DataTypeSequence());
		}
		

		X509DataType.X509DataTypeBuilder prune();
	}

	/*********************** Immutable Implementation of X509DataType  ***********************/
	class X509DataTypeImpl implements X509DataType {
		private final List<? extends X509DataTypeSequence> x509DataTypeSequence;
		
		protected X509DataTypeImpl(X509DataType.X509DataTypeBuilder builder) {
			this.x509DataTypeSequence = ofNullable(builder.getX509DataTypeSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("x509DataTypeSequence")
		public List<? extends X509DataTypeSequence> getX509DataTypeSequence() {
			return x509DataTypeSequence;
		}
		
		@Override
		public X509DataType build() {
			return this;
		}
		
		@Override
		public X509DataType.X509DataTypeBuilder toBuilder() {
			X509DataType.X509DataTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(X509DataType.X509DataTypeBuilder builder) {
			ofNullable(getX509DataTypeSequence()).ifPresent(builder::setX509DataTypeSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			X509DataType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(x509DataTypeSequence, _that.getX509DataTypeSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (x509DataTypeSequence != null ? x509DataTypeSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "X509DataType {" +
				"x509DataTypeSequence=" + this.x509DataTypeSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of X509DataType  ***********************/
	class X509DataTypeBuilderImpl implements X509DataType.X509DataTypeBuilder {
	
		protected List<X509DataTypeSequence.X509DataTypeSequenceBuilder> x509DataTypeSequence = new ArrayList<>();
	
		public X509DataTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("x509DataTypeSequence")
		public List<? extends X509DataTypeSequence.X509DataTypeSequenceBuilder> getX509DataTypeSequence() {
			return x509DataTypeSequence;
		}
		
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder getOrCreateX509DataTypeSequence(int _index) {
		
			if (x509DataTypeSequence==null) {
				this.x509DataTypeSequence = new ArrayList<>();
			}
			X509DataTypeSequence.X509DataTypeSequenceBuilder result;
			return getIndex(x509DataTypeSequence, _index, () -> {
						X509DataTypeSequence.X509DataTypeSequenceBuilder newX509DataTypeSequence = X509DataTypeSequence.builder();
						return newX509DataTypeSequence;
					});
		}
		
		@Override
		@RosettaAttribute("x509DataTypeSequence")
		public X509DataType.X509DataTypeBuilder addX509DataTypeSequence(X509DataTypeSequence x509DataTypeSequence) {
			if (x509DataTypeSequence!=null) this.x509DataTypeSequence.add(x509DataTypeSequence.toBuilder());
			return this;
		}
		
		@Override
		public X509DataType.X509DataTypeBuilder addX509DataTypeSequence(X509DataTypeSequence x509DataTypeSequence, int _idx) {
			getIndex(this.x509DataTypeSequence, _idx, () -> x509DataTypeSequence.toBuilder());
			return this;
		}
		@Override 
		public X509DataType.X509DataTypeBuilder addX509DataTypeSequence(List<? extends X509DataTypeSequence> x509DataTypeSequences) {
			if (x509DataTypeSequences != null) {
				for (X509DataTypeSequence toAdd : x509DataTypeSequences) {
					this.x509DataTypeSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public X509DataType.X509DataTypeBuilder setX509DataTypeSequence(List<? extends X509DataTypeSequence> x509DataTypeSequences) {
			if (x509DataTypeSequences == null)  {
				this.x509DataTypeSequence = new ArrayList<>();
			}
			else {
				this.x509DataTypeSequence = x509DataTypeSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public X509DataType build() {
			return new X509DataType.X509DataTypeImpl(this);
		}
		
		@Override
		public X509DataType.X509DataTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public X509DataType.X509DataTypeBuilder prune() {
			x509DataTypeSequence = x509DataTypeSequence.stream().filter(b->b!=null).<X509DataTypeSequence.X509DataTypeSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getX509DataTypeSequence()!=null && getX509DataTypeSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public X509DataType.X509DataTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			X509DataType.X509DataTypeBuilder o = (X509DataType.X509DataTypeBuilder) other;
			
			merger.mergeRosetta(getX509DataTypeSequence(), o.getX509DataTypeSequence(), this::getOrCreateX509DataTypeSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			X509DataType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(x509DataTypeSequence, _that.getX509DataTypeSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (x509DataTypeSequence != null ? x509DataTypeSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "X509DataTypeBuilder {" +
				"x509DataTypeSequence=" + this.x509DataTypeSequence +
			'}';
		}
	}
}
