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
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.LoanContract;
import fpml.confirmation.LoanContractDetailsModel;
import fpml.confirmation.LoanContractDetailsModel.LoanContractDetailsModelBuilder;
import fpml.confirmation.LoanContractDetailsModel.LoanContractDetailsModelBuilderImpl;
import fpml.confirmation.LoanContractDetailsModel.LoanContractDetailsModelImpl;
import fpml.confirmation.LoanContractSummary;
import fpml.confirmation.meta.LoanContractDetailsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model used to reference a loan contract by either identifier, summary or full contract details, within various notifications.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanContractDetailsModel", builder=LoanContractDetailsModel.LoanContractDetailsModelBuilderImpl.class, version="${project.version}")
public interface LoanContractDetailsModel extends RosettaModelObject {

	LoanContractDetailsModelMeta metaData = new LoanContractDetailsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A deal summary structure.
	 */
	FacilityContractIdentifier getContractIdentifier();
	/**
	 * A facility summary structure.
	 */
	LoanContractSummary getContractSummary();
	LoanContract getContract();

	/*********************** Build Methods  ***********************/
	LoanContractDetailsModel build();
	
	LoanContractDetailsModel.LoanContractDetailsModelBuilder toBuilder();
	
	static LoanContractDetailsModel.LoanContractDetailsModelBuilder builder() {
		return new LoanContractDetailsModel.LoanContractDetailsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractDetailsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanContractDetailsModel> getType() {
		return LoanContractDetailsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("contractIdentifier"), processor, FacilityContractIdentifier.class, getContractIdentifier());
		processRosetta(path.newSubPath("contractSummary"), processor, LoanContractSummary.class, getContractSummary());
		processRosetta(path.newSubPath("contract"), processor, LoanContract.class, getContract());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractDetailsModelBuilder extends LoanContractDetailsModel, RosettaModelObjectBuilder {
		FacilityContractIdentifier.FacilityContractIdentifierBuilder getOrCreateContractIdentifier();
		FacilityContractIdentifier.FacilityContractIdentifierBuilder getContractIdentifier();
		LoanContractSummary.LoanContractSummaryBuilder getOrCreateContractSummary();
		LoanContractSummary.LoanContractSummaryBuilder getContractSummary();
		LoanContract.LoanContractBuilder getOrCreateContract();
		LoanContract.LoanContractBuilder getContract();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder setContractIdentifier(FacilityContractIdentifier contractIdentifier);
		LoanContractDetailsModel.LoanContractDetailsModelBuilder setContractSummary(LoanContractSummary contractSummary);
		LoanContractDetailsModel.LoanContractDetailsModelBuilder setContract(LoanContract contract);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("contractIdentifier"), processor, FacilityContractIdentifier.FacilityContractIdentifierBuilder.class, getContractIdentifier());
			processRosetta(path.newSubPath("contractSummary"), processor, LoanContractSummary.LoanContractSummaryBuilder.class, getContractSummary());
			processRosetta(path.newSubPath("contract"), processor, LoanContract.LoanContractBuilder.class, getContract());
		}
		

		LoanContractDetailsModel.LoanContractDetailsModelBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractDetailsModel  ***********************/
	class LoanContractDetailsModelImpl implements LoanContractDetailsModel {
		private final FacilityContractIdentifier contractIdentifier;
		private final LoanContractSummary contractSummary;
		private final LoanContract contract;
		
		protected LoanContractDetailsModelImpl(LoanContractDetailsModel.LoanContractDetailsModelBuilder builder) {
			this.contractIdentifier = ofNullable(builder.getContractIdentifier()).map(f->f.build()).orElse(null);
			this.contractSummary = ofNullable(builder.getContractSummary()).map(f->f.build()).orElse(null);
			this.contract = ofNullable(builder.getContract()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("contractIdentifier")
		public FacilityContractIdentifier getContractIdentifier() {
			return contractIdentifier;
		}
		
		@Override
		@RosettaAttribute("contractSummary")
		public LoanContractSummary getContractSummary() {
			return contractSummary;
		}
		
		@Override
		@RosettaAttribute("contract")
		public LoanContract getContract() {
			return contract;
		}
		
		@Override
		public LoanContractDetailsModel build() {
			return this;
		}
		
		@Override
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder toBuilder() {
			LoanContractDetailsModel.LoanContractDetailsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractDetailsModel.LoanContractDetailsModelBuilder builder) {
			ofNullable(getContractIdentifier()).ifPresent(builder::setContractIdentifier);
			ofNullable(getContractSummary()).ifPresent(builder::setContractSummary);
			ofNullable(getContract()).ifPresent(builder::setContract);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(contractIdentifier, _that.getContractIdentifier())) return false;
			if (!Objects.equals(contractSummary, _that.getContractSummary())) return false;
			if (!Objects.equals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractIdentifier != null ? contractIdentifier.hashCode() : 0);
			_result = 31 * _result + (contractSummary != null ? contractSummary.hashCode() : 0);
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractDetailsModel {" +
				"contractIdentifier=" + this.contractIdentifier + ", " +
				"contractSummary=" + this.contractSummary + ", " +
				"contract=" + this.contract +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanContractDetailsModel  ***********************/
	class LoanContractDetailsModelBuilderImpl implements LoanContractDetailsModel.LoanContractDetailsModelBuilder {
	
		protected FacilityContractIdentifier.FacilityContractIdentifierBuilder contractIdentifier;
		protected LoanContractSummary.LoanContractSummaryBuilder contractSummary;
		protected LoanContract.LoanContractBuilder contract;
	
		public LoanContractDetailsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("contractIdentifier")
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder getContractIdentifier() {
			return contractIdentifier;
		}
		
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder getOrCreateContractIdentifier() {
			FacilityContractIdentifier.FacilityContractIdentifierBuilder result;
			if (contractIdentifier!=null) {
				result = contractIdentifier;
			}
			else {
				result = contractIdentifier = FacilityContractIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractSummary")
		public LoanContractSummary.LoanContractSummaryBuilder getContractSummary() {
			return contractSummary;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder getOrCreateContractSummary() {
			LoanContractSummary.LoanContractSummaryBuilder result;
			if (contractSummary!=null) {
				result = contractSummary;
			}
			else {
				result = contractSummary = LoanContractSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contract")
		public LoanContract.LoanContractBuilder getContract() {
			return contract;
		}
		
		@Override
		public LoanContract.LoanContractBuilder getOrCreateContract() {
			LoanContract.LoanContractBuilder result;
			if (contract!=null) {
				result = contract;
			}
			else {
				result = contract = LoanContract.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractIdentifier")
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder setContractIdentifier(FacilityContractIdentifier contractIdentifier) {
			this.contractIdentifier = contractIdentifier==null?null:contractIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("contractSummary")
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder setContractSummary(LoanContractSummary contractSummary) {
			this.contractSummary = contractSummary==null?null:contractSummary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("contract")
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder setContract(LoanContract contract) {
			this.contract = contract==null?null:contract.toBuilder();
			return this;
		}
		
		@Override
		public LoanContractDetailsModel build() {
			return new LoanContractDetailsModel.LoanContractDetailsModelImpl(this);
		}
		
		@Override
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder prune() {
			if (contractIdentifier!=null && !contractIdentifier.prune().hasData()) contractIdentifier = null;
			if (contractSummary!=null && !contractSummary.prune().hasData()) contractSummary = null;
			if (contract!=null && !contract.prune().hasData()) contract = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContractIdentifier()!=null && getContractIdentifier().hasData()) return true;
			if (getContractSummary()!=null && getContractSummary().hasData()) return true;
			if (getContract()!=null && getContract().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanContractDetailsModel.LoanContractDetailsModelBuilder o = (LoanContractDetailsModel.LoanContractDetailsModelBuilder) other;
			
			merger.mergeRosetta(getContractIdentifier(), o.getContractIdentifier(), this::setContractIdentifier);
			merger.mergeRosetta(getContractSummary(), o.getContractSummary(), this::setContractSummary);
			merger.mergeRosetta(getContract(), o.getContract(), this::setContract);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(contractIdentifier, _that.getContractIdentifier())) return false;
			if (!Objects.equals(contractSummary, _that.getContractSummary())) return false;
			if (!Objects.equals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractIdentifier != null ? contractIdentifier.hashCode() : 0);
			_result = 31 * _result + (contractSummary != null ? contractSummary.hashCode() : 0);
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractDetailsModelBuilder {" +
				"contractIdentifier=" + this.contractIdentifier + ", " +
				"contractSummary=" + this.contractSummary + ", " +
				"contract=" + this.contract +
			'}';
		}
	}
}
