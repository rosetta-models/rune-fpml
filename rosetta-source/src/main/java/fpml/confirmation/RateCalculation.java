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
import fpml.confirmation.Rate;
import fpml.confirmation.Rate.RateBuilder;
import fpml.confirmation.Rate.RateBuilderImpl;
import fpml.confirmation.Rate.RateImpl;
import fpml.confirmation.RateCalculation;
import fpml.confirmation.RateCalculation.RateCalculationBuilder;
import fpml.confirmation.RateCalculation.RateCalculationBuilderImpl;
import fpml.confirmation.RateCalculation.RateCalculationImpl;
import fpml.confirmation.meta.RateCalculationMeta;


/**
 * The base element for the floating rate calculation definitions.
 * @version ${project.version}
 */
@RosettaDataType(value="RateCalculation", builder=RateCalculation.RateCalculationBuilderImpl.class, version="${project.version}")
public interface RateCalculation extends Rate {

	RateCalculationMeta metaData = new RateCalculationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RateCalculation build();
	
	RateCalculation.RateCalculationBuilder toBuilder();
	
	static RateCalculation.RateCalculationBuilder builder() {
		return new RateCalculation.RateCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RateCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RateCalculation> getType() {
		return RateCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RateCalculationBuilder extends RateCalculation, Rate.RateBuilder {
		RateCalculation.RateCalculationBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		RateCalculation.RateCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of RateCalculation  ***********************/
	class RateCalculationImpl extends Rate.RateImpl implements RateCalculation {
		
		protected RateCalculationImpl(RateCalculation.RateCalculationBuilder builder) {
			super(builder);
		}
		
		@Override
		public RateCalculation build() {
			return this;
		}
		
		@Override
		public RateCalculation.RateCalculationBuilder toBuilder() {
			RateCalculation.RateCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateCalculation.RateCalculationBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "RateCalculation {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RateCalculation  ***********************/
	class RateCalculationBuilderImpl extends Rate.RateBuilderImpl  implements RateCalculation.RateCalculationBuilder {
	
	
		public RateCalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public RateCalculation.RateCalculationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public RateCalculation build() {
			return new RateCalculation.RateCalculationImpl(this);
		}
		
		@Override
		public RateCalculation.RateCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateCalculation.RateCalculationBuilder prune() {
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
		public RateCalculation.RateCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RateCalculation.RateCalculationBuilder o = (RateCalculation.RateCalculationBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "RateCalculationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
