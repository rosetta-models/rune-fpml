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
import fpml.confirmation.Postponement;
import fpml.confirmation.Postponement.PostponementBuilder;
import fpml.confirmation.Postponement.PostponementBuilderImpl;
import fpml.confirmation.Postponement.PostponementImpl;
import fpml.confirmation.ValuationPostponement;
import fpml.confirmation.ValuationPostponement.ValuationPostponementBuilder;
import fpml.confirmation.ValuationPostponement.ValuationPostponementBuilderImpl;
import fpml.confirmation.ValuationPostponement.ValuationPostponementImpl;
import fpml.confirmation.meta.ValuationPostponementMeta;


/**
 * Indicates that the Valuation Date for the tranaction shall be deemed to be the first Business Day following the day on which the applicable Disruption Event ceases to exist, unless the events continues to exists for more than a maximum number of days.
 * @version ${project.version}
 */
@RosettaDataType(value="ValuationPostponement", builder=ValuationPostponement.ValuationPostponementBuilderImpl.class, version="${project.version}")
public interface ValuationPostponement extends Postponement {

	ValuationPostponementMeta metaData = new ValuationPostponementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ValuationPostponement build();
	
	ValuationPostponement.ValuationPostponementBuilder toBuilder();
	
	static ValuationPostponement.ValuationPostponementBuilder builder() {
		return new ValuationPostponement.ValuationPostponementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationPostponement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValuationPostponement> getType() {
		return ValuationPostponement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("maximumNumberOfDays"), Integer.class, getMaximumNumberOfDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationPostponementBuilder extends ValuationPostponement, Postponement.PostponementBuilder {
		ValuationPostponement.ValuationPostponementBuilder setMaximumNumberOfDays(Integer maximumNumberOfDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("maximumNumberOfDays"), Integer.class, getMaximumNumberOfDays(), this);
		}
		

		ValuationPostponement.ValuationPostponementBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationPostponement  ***********************/
	class ValuationPostponementImpl extends Postponement.PostponementImpl implements ValuationPostponement {
		
		protected ValuationPostponementImpl(ValuationPostponement.ValuationPostponementBuilder builder) {
			super(builder);
		}
		
		@Override
		public ValuationPostponement build() {
			return this;
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder toBuilder() {
			ValuationPostponement.ValuationPostponementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationPostponement.ValuationPostponementBuilder builder) {
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
			return "ValuationPostponement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationPostponement  ***********************/
	class ValuationPostponementBuilderImpl extends Postponement.PostponementBuilderImpl  implements ValuationPostponement.ValuationPostponementBuilder {
	
	
		public ValuationPostponementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("maximumNumberOfDays")
		public ValuationPostponement.ValuationPostponementBuilder setMaximumNumberOfDays(Integer maximumNumberOfDays) {
			this.maximumNumberOfDays = maximumNumberOfDays==null?null:maximumNumberOfDays;
			return this;
		}
		
		@Override
		public ValuationPostponement build() {
			return new ValuationPostponement.ValuationPostponementImpl(this);
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationPostponement.ValuationPostponementBuilder prune() {
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
		public ValuationPostponement.ValuationPostponementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ValuationPostponement.ValuationPostponementBuilder o = (ValuationPostponement.ValuationPostponementBuilder) other;
			
			
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
			return "ValuationPostponementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
