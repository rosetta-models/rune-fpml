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
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.SubstitutionDerivativeParametersModel;
import fpml.confirmation.SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder;
import fpml.confirmation.SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilderImpl;
import fpml.confirmation.SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelImpl;
import fpml.confirmation.meta.SubstitutionDerivativeParametersModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Parameters used in the computation of a derivative by substituting a supplied market environment.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SubstitutionDerivativeParametersModel", builder=SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SubstitutionDerivativeParametersModel extends RosettaModelObject {

	SubstitutionDerivativeParametersModelMeta metaData = new SubstitutionDerivativeParametersModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the replacement version of the market input, e.g. a bumped yield curve.
	 */
	PricingStructureReference getReplacementMarketInput();

	/*********************** Build Methods  ***********************/
	SubstitutionDerivativeParametersModel build();
	
	SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder toBuilder();
	
	static SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder builder() {
		return new SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SubstitutionDerivativeParametersModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SubstitutionDerivativeParametersModel> getType() {
		return SubstitutionDerivativeParametersModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("replacementMarketInput"), processor, PricingStructureReference.class, getReplacementMarketInput());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SubstitutionDerivativeParametersModelBuilder extends SubstitutionDerivativeParametersModel, RosettaModelObjectBuilder {
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateReplacementMarketInput();
		PricingStructureReference.PricingStructureReferenceBuilder getReplacementMarketInput();
		SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder setReplacementMarketInput(PricingStructureReference replacementMarketInput);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("replacementMarketInput"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getReplacementMarketInput());
		}
		

		SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder prune();
	}

	/*********************** Immutable Implementation of SubstitutionDerivativeParametersModel  ***********************/
	class SubstitutionDerivativeParametersModelImpl implements SubstitutionDerivativeParametersModel {
		private final PricingStructureReference replacementMarketInput;
		
		protected SubstitutionDerivativeParametersModelImpl(SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder builder) {
			this.replacementMarketInput = ofNullable(builder.getReplacementMarketInput()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("replacementMarketInput")
		public PricingStructureReference getReplacementMarketInput() {
			return replacementMarketInput;
		}
		
		@Override
		public SubstitutionDerivativeParametersModel build() {
			return this;
		}
		
		@Override
		public SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder toBuilder() {
			SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder builder) {
			ofNullable(getReplacementMarketInput()).ifPresent(builder::setReplacementMarketInput);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutionDerivativeParametersModel _that = getType().cast(o);
		
			if (!Objects.equals(replacementMarketInput, _that.getReplacementMarketInput())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (replacementMarketInput != null ? replacementMarketInput.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutionDerivativeParametersModel {" +
				"replacementMarketInput=" + this.replacementMarketInput +
			'}';
		}
	}

	/*********************** Builder Implementation of SubstitutionDerivativeParametersModel  ***********************/
	class SubstitutionDerivativeParametersModelBuilderImpl implements SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder {
	
		protected PricingStructureReference.PricingStructureReferenceBuilder replacementMarketInput;
	
		public SubstitutionDerivativeParametersModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("replacementMarketInput")
		public PricingStructureReference.PricingStructureReferenceBuilder getReplacementMarketInput() {
			return replacementMarketInput;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateReplacementMarketInput() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (replacementMarketInput!=null) {
				result = replacementMarketInput;
			}
			else {
				result = replacementMarketInput = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("replacementMarketInput")
		public SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder setReplacementMarketInput(PricingStructureReference replacementMarketInput) {
			this.replacementMarketInput = replacementMarketInput==null?null:replacementMarketInput.toBuilder();
			return this;
		}
		
		@Override
		public SubstitutionDerivativeParametersModel build() {
			return new SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelImpl(this);
		}
		
		@Override
		public SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder prune() {
			if (replacementMarketInput!=null && !replacementMarketInput.prune().hasData()) replacementMarketInput = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReplacementMarketInput()!=null && getReplacementMarketInput().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder o = (SubstitutionDerivativeParametersModel.SubstitutionDerivativeParametersModelBuilder) other;
			
			merger.mergeRosetta(getReplacementMarketInput(), o.getReplacementMarketInput(), this::setReplacementMarketInput);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutionDerivativeParametersModel _that = getType().cast(o);
		
			if (!Objects.equals(replacementMarketInput, _that.getReplacementMarketInput())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (replacementMarketInput != null ? replacementMarketInput.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutionDerivativeParametersModelBuilder {" +
				"replacementMarketInput=" + this.replacementMarketInput +
			'}';
		}
	}
}
