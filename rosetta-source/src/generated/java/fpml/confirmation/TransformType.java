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
import fpml.confirmation.TransformType;
import fpml.confirmation.TransformType.TransformTypeBuilder;
import fpml.confirmation.TransformType.TransformTypeBuilderImpl;
import fpml.confirmation.TransformType.TransformTypeImpl;
import fpml.confirmation.TransformTypeChoice;
import fpml.confirmation.meta.TransformTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TransformType", builder=TransformType.TransformTypeBuilderImpl.class, version="${project.version}")
public interface TransformType extends RosettaModelObject {

	TransformTypeMeta metaData = new TransformTypeMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends TransformTypeChoice> getTransformTypeChoice();
	String getAlgorithm();

	/*********************** Build Methods  ***********************/
	TransformType build();
	
	TransformType.TransformTypeBuilder toBuilder();
	
	static TransformType.TransformTypeBuilder builder() {
		return new TransformType.TransformTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransformType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TransformType> getType() {
		return TransformType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transformTypeChoice"), processor, TransformTypeChoice.class, getTransformTypeChoice());
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransformTypeBuilder extends TransformType, RosettaModelObjectBuilder {
		TransformTypeChoice.TransformTypeChoiceBuilder getOrCreateTransformTypeChoice(int _index);
		List<? extends TransformTypeChoice.TransformTypeChoiceBuilder> getTransformTypeChoice();
		TransformType.TransformTypeBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice0);
		TransformType.TransformTypeBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice1, int _idx);
		TransformType.TransformTypeBuilder addTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoice2);
		TransformType.TransformTypeBuilder setTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoice3);
		TransformType.TransformTypeBuilder setAlgorithm(String algorithm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transformTypeChoice"), processor, TransformTypeChoice.TransformTypeChoiceBuilder.class, getTransformTypeChoice());
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		}
		

		TransformType.TransformTypeBuilder prune();
	}

	/*********************** Immutable Implementation of TransformType  ***********************/
	class TransformTypeImpl implements TransformType {
		private final List<? extends TransformTypeChoice> transformTypeChoice;
		private final String algorithm;
		
		protected TransformTypeImpl(TransformType.TransformTypeBuilder builder) {
			this.transformTypeChoice = ofNullable(builder.getTransformTypeChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.algorithm = builder.getAlgorithm();
		}
		
		@Override
		@RosettaAttribute("transformTypeChoice")
		public List<? extends TransformTypeChoice> getTransformTypeChoice() {
			return transformTypeChoice;
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		public TransformType build() {
			return this;
		}
		
		@Override
		public TransformType.TransformTypeBuilder toBuilder() {
			TransformType.TransformTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransformType.TransformTypeBuilder builder) {
			ofNullable(getTransformTypeChoice()).ifPresent(builder::setTransformTypeChoice);
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransformType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(transformTypeChoice, _that.getTransformTypeChoice())) return false;
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transformTypeChoice != null ? transformTypeChoice.hashCode() : 0);
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformType {" +
				"transformTypeChoice=" + this.transformTypeChoice + ", " +
				"algorithm=" + this.algorithm +
			'}';
		}
	}

	/*********************** Builder Implementation of TransformType  ***********************/
	class TransformTypeBuilderImpl implements TransformType.TransformTypeBuilder {
	
		protected List<TransformTypeChoice.TransformTypeChoiceBuilder> transformTypeChoice = new ArrayList<>();
		protected String algorithm;
	
		public TransformTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("transformTypeChoice")
		public List<? extends TransformTypeChoice.TransformTypeChoiceBuilder> getTransformTypeChoice() {
			return transformTypeChoice;
		}
		
		public TransformTypeChoice.TransformTypeChoiceBuilder getOrCreateTransformTypeChoice(int _index) {
		
			if (transformTypeChoice==null) {
				this.transformTypeChoice = new ArrayList<>();
			}
			TransformTypeChoice.TransformTypeChoiceBuilder result;
			return getIndex(transformTypeChoice, _index, () -> {
						TransformTypeChoice.TransformTypeChoiceBuilder newTransformTypeChoice = TransformTypeChoice.builder();
						return newTransformTypeChoice;
					});
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		public TransformType.TransformTypeBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice) {
			if (transformTypeChoice!=null) this.transformTypeChoice.add(transformTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public TransformType.TransformTypeBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice, int _idx) {
			getIndex(this.transformTypeChoice, _idx, () -> transformTypeChoice.toBuilder());
			return this;
		}
		@Override 
		public TransformType.TransformTypeBuilder addTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoices) {
			if (transformTypeChoices != null) {
				for (TransformTypeChoice toAdd : transformTypeChoices) {
					this.transformTypeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("transformTypeChoice")
		public TransformType.TransformTypeBuilder setTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoices) {
			if (transformTypeChoices == null)  {
				this.transformTypeChoice = new ArrayList<>();
			}
			else {
				this.transformTypeChoice = transformTypeChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public TransformType.TransformTypeBuilder setAlgorithm(String algorithm) {
			this.algorithm = algorithm==null?null:algorithm;
			return this;
		}
		
		@Override
		public TransformType build() {
			return new TransformType.TransformTypeImpl(this);
		}
		
		@Override
		public TransformType.TransformTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransformType.TransformTypeBuilder prune() {
			transformTypeChoice = transformTypeChoice.stream().filter(b->b!=null).<TransformTypeChoice.TransformTypeChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransformTypeChoice()!=null && getTransformTypeChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAlgorithm()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransformType.TransformTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransformType.TransformTypeBuilder o = (TransformType.TransformTypeBuilder) other;
			
			merger.mergeRosetta(getTransformTypeChoice(), o.getTransformTypeChoice(), this::getOrCreateTransformTypeChoice);
			
			merger.mergeBasic(getAlgorithm(), o.getAlgorithm(), this::setAlgorithm);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransformType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(transformTypeChoice, _that.getTransformTypeChoice())) return false;
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transformTypeChoice != null ? transformTypeChoice.hashCode() : 0);
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformTypeBuilder {" +
				"transformTypeChoice=" + this.transformTypeChoice + ", " +
				"algorithm=" + this.algorithm +
			'}';
		}
	}
}
