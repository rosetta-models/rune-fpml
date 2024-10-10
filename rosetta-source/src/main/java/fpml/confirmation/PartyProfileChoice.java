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
import fpml.confirmation.ApplicableCommunicationDetails;
import fpml.confirmation.ApplicableSettlementInstructionDetails;
import fpml.confirmation.PartyProfileChoice;
import fpml.confirmation.PartyProfileChoice.PartyProfileChoiceBuilder;
import fpml.confirmation.PartyProfileChoice.PartyProfileChoiceBuilderImpl;
import fpml.confirmation.PartyProfileChoice.PartyProfileChoiceImpl;
import fpml.confirmation.meta.PartyProfileChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PartyProfileChoice", builder=PartyProfileChoice.PartyProfileChoiceBuilderImpl.class, version="${project.version}")
public interface PartyProfileChoice extends RosettaModelObject {

	PartyProfileChoiceMeta metaData = new PartyProfileChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Relates an asset, or assets, to an element within a party block (customarily a business unit or person).
	 */
	ApplicableCommunicationDetails getCommunicationDetails();
	/**
	 * Relates an asset, or assets, to set of settlement instructions.
	 */
	ApplicableSettlementInstructionDetails getSettlementInstructionDetails();

	/*********************** Build Methods  ***********************/
	PartyProfileChoice build();
	
	PartyProfileChoice.PartyProfileChoiceBuilder toBuilder();
	
	static PartyProfileChoice.PartyProfileChoiceBuilder builder() {
		return new PartyProfileChoice.PartyProfileChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyProfileChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyProfileChoice> getType() {
		return PartyProfileChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("communicationDetails"), processor, ApplicableCommunicationDetails.class, getCommunicationDetails());
		processRosetta(path.newSubPath("settlementInstructionDetails"), processor, ApplicableSettlementInstructionDetails.class, getSettlementInstructionDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyProfileChoiceBuilder extends PartyProfileChoice, RosettaModelObjectBuilder {
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder getOrCreateCommunicationDetails();
		ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder getCommunicationDetails();
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder getOrCreateSettlementInstructionDetails();
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder getSettlementInstructionDetails();
		PartyProfileChoice.PartyProfileChoiceBuilder setCommunicationDetails(ApplicableCommunicationDetails communicationDetails);
		PartyProfileChoice.PartyProfileChoiceBuilder setSettlementInstructionDetails(ApplicableSettlementInstructionDetails settlementInstructionDetails);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("communicationDetails"), processor, ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder.class, getCommunicationDetails());
			processRosetta(path.newSubPath("settlementInstructionDetails"), processor, ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder.class, getSettlementInstructionDetails());
		}
		

		PartyProfileChoice.PartyProfileChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of PartyProfileChoice  ***********************/
	class PartyProfileChoiceImpl implements PartyProfileChoice {
		private final ApplicableCommunicationDetails communicationDetails;
		private final ApplicableSettlementInstructionDetails settlementInstructionDetails;
		
		protected PartyProfileChoiceImpl(PartyProfileChoice.PartyProfileChoiceBuilder builder) {
			this.communicationDetails = ofNullable(builder.getCommunicationDetails()).map(f->f.build()).orElse(null);
			this.settlementInstructionDetails = ofNullable(builder.getSettlementInstructionDetails()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("communicationDetails")
		public ApplicableCommunicationDetails getCommunicationDetails() {
			return communicationDetails;
		}
		
		@Override
		@RosettaAttribute("settlementInstructionDetails")
		public ApplicableSettlementInstructionDetails getSettlementInstructionDetails() {
			return settlementInstructionDetails;
		}
		
		@Override
		public PartyProfileChoice build() {
			return this;
		}
		
		@Override
		public PartyProfileChoice.PartyProfileChoiceBuilder toBuilder() {
			PartyProfileChoice.PartyProfileChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyProfileChoice.PartyProfileChoiceBuilder builder) {
			ofNullable(getCommunicationDetails()).ifPresent(builder::setCommunicationDetails);
			ofNullable(getSettlementInstructionDetails()).ifPresent(builder::setSettlementInstructionDetails);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileChoice _that = getType().cast(o);
		
			if (!Objects.equals(communicationDetails, _that.getCommunicationDetails())) return false;
			if (!Objects.equals(settlementInstructionDetails, _that.getSettlementInstructionDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (communicationDetails != null ? communicationDetails.hashCode() : 0);
			_result = 31 * _result + (settlementInstructionDetails != null ? settlementInstructionDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileChoice {" +
				"communicationDetails=" + this.communicationDetails + ", " +
				"settlementInstructionDetails=" + this.settlementInstructionDetails +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyProfileChoice  ***********************/
	class PartyProfileChoiceBuilderImpl implements PartyProfileChoice.PartyProfileChoiceBuilder {
	
		protected ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder communicationDetails;
		protected ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder settlementInstructionDetails;
	
		public PartyProfileChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("communicationDetails")
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder getCommunicationDetails() {
			return communicationDetails;
		}
		
		@Override
		public ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder getOrCreateCommunicationDetails() {
			ApplicableCommunicationDetails.ApplicableCommunicationDetailsBuilder result;
			if (communicationDetails!=null) {
				result = communicationDetails;
			}
			else {
				result = communicationDetails = ApplicableCommunicationDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementInstructionDetails")
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder getSettlementInstructionDetails() {
			return settlementInstructionDetails;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder getOrCreateSettlementInstructionDetails() {
			ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder result;
			if (settlementInstructionDetails!=null) {
				result = settlementInstructionDetails;
			}
			else {
				result = settlementInstructionDetails = ApplicableSettlementInstructionDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("communicationDetails")
		public PartyProfileChoice.PartyProfileChoiceBuilder setCommunicationDetails(ApplicableCommunicationDetails communicationDetails) {
			this.communicationDetails = communicationDetails==null?null:communicationDetails.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementInstructionDetails")
		public PartyProfileChoice.PartyProfileChoiceBuilder setSettlementInstructionDetails(ApplicableSettlementInstructionDetails settlementInstructionDetails) {
			this.settlementInstructionDetails = settlementInstructionDetails==null?null:settlementInstructionDetails.toBuilder();
			return this;
		}
		
		@Override
		public PartyProfileChoice build() {
			return new PartyProfileChoice.PartyProfileChoiceImpl(this);
		}
		
		@Override
		public PartyProfileChoice.PartyProfileChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileChoice.PartyProfileChoiceBuilder prune() {
			if (communicationDetails!=null && !communicationDetails.prune().hasData()) communicationDetails = null;
			if (settlementInstructionDetails!=null && !settlementInstructionDetails.prune().hasData()) settlementInstructionDetails = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommunicationDetails()!=null && getCommunicationDetails().hasData()) return true;
			if (getSettlementInstructionDetails()!=null && getSettlementInstructionDetails().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileChoice.PartyProfileChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyProfileChoice.PartyProfileChoiceBuilder o = (PartyProfileChoice.PartyProfileChoiceBuilder) other;
			
			merger.mergeRosetta(getCommunicationDetails(), o.getCommunicationDetails(), this::setCommunicationDetails);
			merger.mergeRosetta(getSettlementInstructionDetails(), o.getSettlementInstructionDetails(), this::setSettlementInstructionDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileChoice _that = getType().cast(o);
		
			if (!Objects.equals(communicationDetails, _that.getCommunicationDetails())) return false;
			if (!Objects.equals(settlementInstructionDetails, _that.getSettlementInstructionDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (communicationDetails != null ? communicationDetails.hashCode() : 0);
			_result = 31 * _result + (settlementInstructionDetails != null ? settlementInstructionDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileChoiceBuilder {" +
				"communicationDetails=" + this.communicationDetails + ", " +
				"settlementInstructionDetails=" + this.settlementInstructionDetails +
			'}';
		}
	}
}
