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
import fpml.confirmation.LoanTradingParticipationSettlementTermsModel;
import fpml.confirmation.LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder;
import fpml.confirmation.LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilderImpl;
import fpml.confirmation.LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelImpl;
import fpml.confirmation.LoanTradingVotingRightsEnum;
import fpml.confirmation.meta.LoanTradingParticipationSettlementTermsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model which contains trade settlement terms for participations.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradingParticipationSettlementTermsModel", builder=LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradingParticipationSettlementTermsModel extends RosettaModelObject {

	LoanTradingParticipationSettlementTermsModelMeta metaData = new LoanTradingParticipationSettlementTermsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies whether the buyer is to supply collateral in the case the trade involves a revolver and the trade settles as a participation.
	 */
	Boolean getCollateralRequiredFlag();
	/**
	 * Identifies whether the buyer is to receive voting rights or be retained by the seller.
	 */
	LoanTradingVotingRightsEnum getVotingRights();

	/*********************** Build Methods  ***********************/
	LoanTradingParticipationSettlementTermsModel build();
	
	LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder toBuilder();
	
	static LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder builder() {
		return new LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingParticipationSettlementTermsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingParticipationSettlementTermsModel> getType() {
		return LoanTradingParticipationSettlementTermsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("collateralRequiredFlag"), Boolean.class, getCollateralRequiredFlag(), this);
		processor.processBasic(path.newSubPath("votingRights"), LoanTradingVotingRightsEnum.class, getVotingRights(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingParticipationSettlementTermsModelBuilder extends LoanTradingParticipationSettlementTermsModel, RosettaModelObjectBuilder {
		LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder setCollateralRequiredFlag(Boolean collateralRequiredFlag);
		LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder setVotingRights(LoanTradingVotingRightsEnum votingRights);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("collateralRequiredFlag"), Boolean.class, getCollateralRequiredFlag(), this);
			processor.processBasic(path.newSubPath("votingRights"), LoanTradingVotingRightsEnum.class, getVotingRights(), this);
		}
		

		LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingParticipationSettlementTermsModel  ***********************/
	class LoanTradingParticipationSettlementTermsModelImpl implements LoanTradingParticipationSettlementTermsModel {
		private final Boolean collateralRequiredFlag;
		private final LoanTradingVotingRightsEnum votingRights;
		
		protected LoanTradingParticipationSettlementTermsModelImpl(LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder builder) {
			this.collateralRequiredFlag = builder.getCollateralRequiredFlag();
			this.votingRights = builder.getVotingRights();
		}
		
		@Override
		@RosettaAttribute("collateralRequiredFlag")
		public Boolean getCollateralRequiredFlag() {
			return collateralRequiredFlag;
		}
		
		@Override
		@RosettaAttribute("votingRights")
		public LoanTradingVotingRightsEnum getVotingRights() {
			return votingRights;
		}
		
		@Override
		public LoanTradingParticipationSettlementTermsModel build() {
			return this;
		}
		
		@Override
		public LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder toBuilder() {
			LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder builder) {
			ofNullable(getCollateralRequiredFlag()).ifPresent(builder::setCollateralRequiredFlag);
			ofNullable(getVotingRights()).ifPresent(builder::setVotingRights);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingParticipationSettlementTermsModel _that = getType().cast(o);
		
			if (!Objects.equals(collateralRequiredFlag, _that.getCollateralRequiredFlag())) return false;
			if (!Objects.equals(votingRights, _that.getVotingRights())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralRequiredFlag != null ? collateralRequiredFlag.hashCode() : 0);
			_result = 31 * _result + (votingRights != null ? votingRights.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingParticipationSettlementTermsModel {" +
				"collateralRequiredFlag=" + this.collateralRequiredFlag + ", " +
				"votingRights=" + this.votingRights +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingParticipationSettlementTermsModel  ***********************/
	class LoanTradingParticipationSettlementTermsModelBuilderImpl implements LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder {
	
		protected Boolean collateralRequiredFlag;
		protected LoanTradingVotingRightsEnum votingRights;
	
		public LoanTradingParticipationSettlementTermsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("collateralRequiredFlag")
		public Boolean getCollateralRequiredFlag() {
			return collateralRequiredFlag;
		}
		
		@Override
		@RosettaAttribute("votingRights")
		public LoanTradingVotingRightsEnum getVotingRights() {
			return votingRights;
		}
		
		@Override
		@RosettaAttribute("collateralRequiredFlag")
		public LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder setCollateralRequiredFlag(Boolean collateralRequiredFlag) {
			this.collateralRequiredFlag = collateralRequiredFlag==null?null:collateralRequiredFlag;
			return this;
		}
		@Override
		@RosettaAttribute("votingRights")
		public LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder setVotingRights(LoanTradingVotingRightsEnum votingRights) {
			this.votingRights = votingRights==null?null:votingRights;
			return this;
		}
		
		@Override
		public LoanTradingParticipationSettlementTermsModel build() {
			return new LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelImpl(this);
		}
		
		@Override
		public LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralRequiredFlag()!=null) return true;
			if (getVotingRights()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder o = (LoanTradingParticipationSettlementTermsModel.LoanTradingParticipationSettlementTermsModelBuilder) other;
			
			
			merger.mergeBasic(getCollateralRequiredFlag(), o.getCollateralRequiredFlag(), this::setCollateralRequiredFlag);
			merger.mergeBasic(getVotingRights(), o.getVotingRights(), this::setVotingRights);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingParticipationSettlementTermsModel _that = getType().cast(o);
		
			if (!Objects.equals(collateralRequiredFlag, _that.getCollateralRequiredFlag())) return false;
			if (!Objects.equals(votingRights, _that.getVotingRights())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralRequiredFlag != null ? collateralRequiredFlag.hashCode() : 0);
			_result = 31 * _result + (votingRights != null ? votingRights.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingParticipationSettlementTermsModelBuilder {" +
				"collateralRequiredFlag=" + this.collateralRequiredFlag + ", " +
				"votingRights=" + this.votingRights +
			'}';
		}
	}
}
