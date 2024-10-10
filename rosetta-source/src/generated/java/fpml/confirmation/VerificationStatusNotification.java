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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Reason;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.VerificationStatus;
import fpml.confirmation.VerificationStatusNotification;
import fpml.confirmation.VerificationStatusNotification.VerificationStatusNotificationBuilder;
import fpml.confirmation.VerificationStatusNotification.VerificationStatusNotificationBuilderImpl;
import fpml.confirmation.VerificationStatusNotification.VerificationStatusNotificationImpl;
import fpml.confirmation.meta.VerificationStatusNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="VerificationStatusNotification", builder=VerificationStatusNotification.VerificationStatusNotificationBuilderImpl.class, version="${project.version}")
public interface VerificationStatusNotification extends NonCorrectableRequestMessage {

	VerificationStatusNotificationMeta metaData = new VerificationStatusNotificationMeta();

	/*********************** Getter Methods  ***********************/
	VerificationStatus getStatus();
	/**
	 * The reason for any dispute or change in verification status.
	 */
	List<? extends Reason> getReason();
	PartyTradeIdentifier getPartyTradeIdentifier();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	VerificationStatusNotification build();
	
	VerificationStatusNotification.VerificationStatusNotificationBuilder toBuilder();
	
	static VerificationStatusNotification.VerificationStatusNotificationBuilder builder() {
		return new VerificationStatusNotification.VerificationStatusNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VerificationStatusNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VerificationStatusNotification> getType() {
		return VerificationStatusNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("status"), processor, VerificationStatus.class, getStatus());
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VerificationStatusNotificationBuilder extends VerificationStatusNotification, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		VerificationStatus.VerificationStatusBuilder getOrCreateStatus();
		VerificationStatus.VerificationStatusBuilder getStatus();
		Reason.ReasonBuilder getOrCreateReason(int _index);
		List<? extends Reason.ReasonBuilder> getReason();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getPartyTradeIdentifier();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		VerificationStatusNotification.VerificationStatusNotificationBuilder setExpectedBuild(Integer expectedBuild);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setActualBuild(Integer actualBuild);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setHeader(RequestMessageHeader header);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setValidationModel(ValidationModel validationModel);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setStatus(VerificationStatus status);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(Reason reason0);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(Reason reason1, int _idx);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(List<? extends Reason> reason2);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setReason(List<? extends Reason> reason3);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("status"), processor, VerificationStatus.VerificationStatusBuilder.class, getStatus());
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		VerificationStatusNotification.VerificationStatusNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of VerificationStatusNotification  ***********************/
	class VerificationStatusNotificationImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements VerificationStatusNotification {
		private final VerificationStatus status;
		private final List<? extends Reason> reason;
		private final PartyTradeIdentifier partyTradeIdentifier;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected VerificationStatusNotificationImpl(VerificationStatusNotification.VerificationStatusNotificationBuilder builder) {
			super(builder);
			this.status = ofNullable(builder.getStatus()).map(f->f.build()).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("status")
		public VerificationStatus getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public PartyTradeIdentifier getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public VerificationStatusNotification build() {
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder toBuilder() {
			VerificationStatusNotification.VerificationStatusNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VerificationStatusNotification.VerificationStatusNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VerificationStatusNotification _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationStatusNotification {" +
				"status=" + this.status + ", " +
				"reason=" + this.reason + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VerificationStatusNotification  ***********************/
	class VerificationStatusNotificationBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements VerificationStatusNotification.VerificationStatusNotificationBuilder {
	
		protected VerificationStatus.VerificationStatusBuilder status;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder partyTradeIdentifier;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public VerificationStatusNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("status")
		public VerificationStatus.VerificationStatusBuilder getStatus() {
			return status;
		}
		
		@Override
		public VerificationStatus.VerificationStatusBuilder getOrCreateStatus() {
			VerificationStatus.VerificationStatusBuilder result;
			if (status!=null) {
				result = status;
			}
			else {
				result = status = VerificationStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		public Reason.ReasonBuilder getOrCreateReason(int _index) {
		
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			Reason.ReasonBuilder result;
			return getIndex(reason, _index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (partyTradeIdentifier!=null) {
				result = partyTradeIdentifier;
			}
			else {
				result = partyTradeIdentifier = PartyTradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel() {
			PartiesAndAccountsModel.PartiesAndAccountsModelBuilder result;
			if (partiesAndAccountsModel!=null) {
				result = partiesAndAccountsModel;
			}
			else {
				result = partiesAndAccountsModel = PartiesAndAccountsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("status")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setStatus(VerificationStatus status) {
			this.status = status==null?null:status.toBuilder();
			return this;
		}
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(Reason reason) {
			if (reason!=null) this.reason.add(reason.toBuilder());
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(Reason reason, int _idx) {
			getIndex(this.reason, _idx, () -> reason.toBuilder());
			return this;
		}
		@Override 
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reason")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null)  {
				this.reason = new ArrayList<>();
			}
			else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier) {
			this.partyTradeIdentifier = partyTradeIdentifier==null?null:partyTradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public VerificationStatusNotification build() {
			return new VerificationStatusNotification.VerificationStatusNotificationImpl(this);
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder prune() {
			super.prune();
			if (status!=null && !status.prune().hasData()) status = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyTradeIdentifier!=null && !partyTradeIdentifier.prune().hasData()) partyTradeIdentifier = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStatus()!=null && getStatus().hasData()) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VerificationStatusNotification.VerificationStatusNotificationBuilder o = (VerificationStatusNotification.VerificationStatusNotificationBuilder) other;
			
			merger.mergeRosetta(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::setPartyTradeIdentifier);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VerificationStatusNotification _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationStatusNotificationBuilder {" +
				"status=" + this.status + ", " +
				"reason=" + this.reason + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
