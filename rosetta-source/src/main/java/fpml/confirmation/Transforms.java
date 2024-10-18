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
import fpml.confirmation.TransformType;
import fpml.confirmation.Transforms;
import fpml.confirmation.Transforms.TransformsBuilder;
import fpml.confirmation.Transforms.TransformsBuilderImpl;
import fpml.confirmation.Transforms.TransformsImpl;
import fpml.confirmation.TransformsType;
import fpml.confirmation.TransformsType.TransformsTypeBuilder;
import fpml.confirmation.TransformsType.TransformsTypeBuilderImpl;
import fpml.confirmation.TransformsType.TransformsTypeImpl;
import fpml.confirmation.meta.TransformsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="Transforms", builder=Transforms.TransformsBuilderImpl.class, version="${project.version}")
public interface Transforms extends TransformsType {

	TransformsMeta metaData = new TransformsMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Transforms build();
	
	Transforms.TransformsBuilder toBuilder();
	
	static Transforms.TransformsBuilder builder() {
		return new Transforms.TransformsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Transforms> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Transforms> getType() {
		return Transforms.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transform"), processor, TransformType.class, getTransform());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransformsBuilder extends Transforms, TransformsType.TransformsTypeBuilder {
		Transforms.TransformsBuilder addTransform(TransformType transform0);
		Transforms.TransformsBuilder addTransform(TransformType transform1, int _idx);
		Transforms.TransformsBuilder addTransform(List<? extends TransformType> transform2);
		Transforms.TransformsBuilder setTransform(List<? extends TransformType> transform3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transform"), processor, TransformType.TransformTypeBuilder.class, getTransform());
		}
		

		Transforms.TransformsBuilder prune();
	}

	/*********************** Immutable Implementation of Transforms  ***********************/
	class TransformsImpl extends TransformsType.TransformsTypeImpl implements Transforms {
		
		protected TransformsImpl(Transforms.TransformsBuilder builder) {
			super(builder);
		}
		
		@Override
		public Transforms build() {
			return this;
		}
		
		@Override
		public Transforms.TransformsBuilder toBuilder() {
			Transforms.TransformsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Transforms.TransformsBuilder builder) {
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
			return "Transforms {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Transforms  ***********************/
	class TransformsBuilderImpl extends TransformsType.TransformsTypeBuilderImpl  implements Transforms.TransformsBuilder {
	
	
		public TransformsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("transform")
		public Transforms.TransformsBuilder addTransform(TransformType transform) {
			if (transform!=null) this.transform.add(transform.toBuilder());
			return this;
		}
		
		@Override
		public Transforms.TransformsBuilder addTransform(TransformType transform, int _idx) {
			getIndex(this.transform, _idx, () -> transform.toBuilder());
			return this;
		}
		@Override 
		public Transforms.TransformsBuilder addTransform(List<? extends TransformType> transforms) {
			if (transforms != null) {
				for (TransformType toAdd : transforms) {
					this.transform.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Transforms.TransformsBuilder setTransform(List<? extends TransformType> transforms) {
			if (transforms == null)  {
				this.transform = new ArrayList<>();
			}
			else {
				this.transform = transforms.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Transforms build() {
			return new Transforms.TransformsImpl(this);
		}
		
		@Override
		public Transforms.TransformsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transforms.TransformsBuilder prune() {
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
		public Transforms.TransformsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Transforms.TransformsBuilder o = (Transforms.TransformsBuilder) other;
			
			
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
			return "TransformsBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
