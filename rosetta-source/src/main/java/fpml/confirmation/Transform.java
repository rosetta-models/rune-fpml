package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Transform;
import fpml.confirmation.Transform.TransformBuilder;
import fpml.confirmation.Transform.TransformBuilderImpl;
import fpml.confirmation.Transform.TransformImpl;
import fpml.confirmation.TransformType;
import fpml.confirmation.TransformType.TransformTypeBuilder;
import fpml.confirmation.TransformType.TransformTypeBuilderImpl;
import fpml.confirmation.TransformType.TransformTypeImpl;
import fpml.confirmation.TransformTypeChoice;
import fpml.confirmation.meta.TransformMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="Transform", builder=Transform.TransformBuilderImpl.class, version="${project.version}")
public interface Transform extends TransformType {

	TransformMeta metaData = new TransformMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Transform build();
	
	Transform.TransformBuilder toBuilder();
	
	static Transform.TransformBuilder builder() {
		return new Transform.TransformBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Transform> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Transform> getType() {
		return Transform.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transformTypeChoice"), processor, TransformTypeChoice.class, getTransformTypeChoice());
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransformBuilder extends Transform, TransformType.TransformTypeBuilder {
		Transform.TransformBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice0);
		Transform.TransformBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice1, int _idx);
		Transform.TransformBuilder addTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoice2);
		Transform.TransformBuilder setTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoice3);
		Transform.TransformBuilder setAlgorithm(String algorithm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transformTypeChoice"), processor, TransformTypeChoice.TransformTypeChoiceBuilder.class, getTransformTypeChoice());
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		}
		

		Transform.TransformBuilder prune();
	}

	/*********************** Immutable Implementation of Transform  ***********************/
	class TransformImpl extends TransformType.TransformTypeImpl implements Transform {
		
		protected TransformImpl(Transform.TransformBuilder builder) {
			super(builder);
		}
		
		@Override
		public Transform build() {
			return this;
		}
		
		@Override
		public Transform.TransformBuilder toBuilder() {
			Transform.TransformBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Transform.TransformBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Transform {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Transform  ***********************/
	class TransformBuilderImpl extends TransformType.TransformTypeBuilderImpl  implements Transform.TransformBuilder {
	
	
		public TransformBuilderImpl() {
		}
	
		@Override
		public Transform.TransformBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice) {
			if (transformTypeChoice!=null) this.transformTypeChoice.add(transformTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public Transform.TransformBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice, int _idx) {
			getIndex(this.transformTypeChoice, _idx, () -> transformTypeChoice.toBuilder());
			return this;
		}
		@Override 
		public Transform.TransformBuilder addTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoices) {
			if (transformTypeChoices != null) {
				for (TransformTypeChoice toAdd : transformTypeChoices) {
					this.transformTypeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("transformTypeChoice")
		public Transform.TransformBuilder setTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoices) {
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
		public Transform.TransformBuilder setAlgorithm(String algorithm) {
			this.algorithm = algorithm==null?null:algorithm;
			return this;
		}
		
		@Override
		public Transform build() {
			return new Transform.TransformImpl(this);
		}
		
		@Override
		public Transform.TransformBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transform.TransformBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transform.TransformBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Transform.TransformBuilder o = (Transform.TransformBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
