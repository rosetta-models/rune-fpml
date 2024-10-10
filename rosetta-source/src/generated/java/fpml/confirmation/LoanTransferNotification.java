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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AbstractLoanTradingNotification;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanTradeEvent;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.LoanTransfer;
import fpml.confirmation.LoanTransferNotification;
import fpml.confirmation.LoanTransferNotification.LoanTransferNotificationBuilder;
import fpml.confirmation.LoanTransferNotification.LoanTransferNotificationBuilderImpl;
import fpml.confirmation.LoanTransferNotification.LoanTransferNotificationImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanTransferNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate details to establish a master trade, from counterparty to admin agent.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTransferNotification", builder=LoanTransferNotification.LoanTransferNotificationBuilderImpl.class, version="${project.version}")
public interface LoanTransferNotification extends AbstractLoanTradingNotification {

	LoanTransferNotificationMeta metaData = new LoanTransferNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to establish the loan transfer event. This structure contains an event identifier for the trade as well as a reference to the details of the trade, contained in an element in the message.
	 */
	LoanTradeEvent getTransferEvent();
	/**
	 * An event structure defining loan transfer information, sent from counterparty to agent. This structure contains the main (e.g. fund manager/main counterparty) trade details.
	 */
	LoanTransfer getTransfer();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanTransferNotification build();
	
	LoanTransferNotification.LoanTransferNotificationBuilder toBuilder();
	
	static LoanTransferNotification.LoanTransferNotificationBuilder builder() {
		return new LoanTransferNotification.LoanTransferNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTransferNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTransferNotification> getType() {
		return LoanTransferNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.class, getRole());
		processRosetta(path.newSubPath("transferEvent"), processor, LoanTradeEvent.class, getTransferEvent());
		processRosetta(path.newSubPath("transfer"), processor, LoanTransfer.class, getTransfer());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTransferNotificationBuilder extends LoanTransferNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanTradeEvent.LoanTradeEventBuilder getOrCreateTransferEvent();
		LoanTradeEvent.LoanTradeEventBuilder getTransferEvent();
		LoanTransfer.LoanTransferBuilder getOrCreateTransfer();
		LoanTransfer.LoanTransferBuilder getTransfer();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanTransferNotification.LoanTransferNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanTransferNotification.LoanTransferNotificationBuilder setActualBuild(Integer actualBuild);
		LoanTransferNotification.LoanTransferNotificationBuilder setHeader(RequestMessageHeader header);
		LoanTransferNotification.LoanTransferNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanTransferNotification.LoanTransferNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanTransferNotification.LoanTransferNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanTransferNotification.LoanTransferNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanTransferNotification.LoanTransferNotificationBuilder setNoticeDate(Date noticeDate);
		LoanTransferNotification.LoanTransferNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanTransferNotification.LoanTransferNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanTransferNotification.LoanTransferNotificationBuilder setTransferEvent(LoanTradeEvent transferEvent);
		LoanTransferNotification.LoanTransferNotificationBuilder setTransfer(LoanTransfer transfer);
		LoanTransferNotification.LoanTransferNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LoanTransferNotification.LoanTransferNotificationBuilder addParty(Party party0);
		LoanTransferNotification.LoanTransferNotificationBuilder addParty(Party party1, int _idx);
		LoanTransferNotification.LoanTransferNotificationBuilder addParty(List<? extends Party> party2);
		LoanTransferNotification.LoanTransferNotificationBuilder setParty(List<? extends Party> party3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.LoanTradingPartyRoleBuilder.class, getRole());
			processRosetta(path.newSubPath("transferEvent"), processor, LoanTradeEvent.LoanTradeEventBuilder.class, getTransferEvent());
			processRosetta(path.newSubPath("transfer"), processor, LoanTransfer.LoanTransferBuilder.class, getTransfer());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanTransferNotification.LoanTransferNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTransferNotification  ***********************/
	class LoanTransferNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanTransferNotification {
		private final LoanTradeEvent transferEvent;
		private final LoanTransfer transfer;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanTransferNotificationImpl(LoanTransferNotification.LoanTransferNotificationBuilder builder) {
			super(builder);
			this.transferEvent = ofNullable(builder.getTransferEvent()).map(f->f.build()).orElse(null);
			this.transfer = ofNullable(builder.getTransfer()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("transferEvent")
		public LoanTradeEvent getTransferEvent() {
			return transferEvent;
		}
		
		@Override
		@RosettaAttribute("transfer")
		public LoanTransfer getTransfer() {
			return transfer;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanTransferNotification build() {
			return this;
		}
		
		@Override
		public LoanTransferNotification.LoanTransferNotificationBuilder toBuilder() {
			LoanTransferNotification.LoanTransferNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTransferNotification.LoanTransferNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTransferEvent()).ifPresent(builder::setTransferEvent);
			ofNullable(getTransfer()).ifPresent(builder::setTransfer);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTransferNotification _that = getType().cast(o);
		
			if (!Objects.equals(transferEvent, _that.getTransferEvent())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (transferEvent != null ? transferEvent.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferNotification {" +
				"transferEvent=" + this.transferEvent + ", " +
				"transfer=" + this.transfer + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTransferNotification  ***********************/
	class LoanTransferNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanTransferNotification.LoanTransferNotificationBuilder {
	
		protected LoanTradeEvent.LoanTradeEventBuilder transferEvent;
		protected LoanTransfer.LoanTransferBuilder transfer;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanTransferNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("transferEvent")
		public LoanTradeEvent.LoanTradeEventBuilder getTransferEvent() {
			return transferEvent;
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder getOrCreateTransferEvent() {
			LoanTradeEvent.LoanTradeEventBuilder result;
			if (transferEvent!=null) {
				result = transferEvent;
			}
			else {
				result = transferEvent = LoanTradeEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transfer")
		public LoanTransfer.LoanTransferBuilder getTransfer() {
			return transfer;
		}
		
		@Override
		public LoanTransfer.LoanTransferBuilder getOrCreateTransfer() {
			LoanTransfer.LoanTransferBuilder result;
			if (transfer!=null) {
				result = transfer;
			}
			else {
				result = transfer = LoanTransfer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel() {
			FacilityDetailsModel.FacilityDetailsModelBuilder result;
			if (facilityDetailsModel!=null) {
				result = facilityDetailsModel;
			}
			else {
				result = facilityDetailsModel = FacilityDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		public Party.PartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(party, _index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public LoanTransferNotification.LoanTransferNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanTransferNotification.LoanTransferNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanTransferNotification.LoanTransferNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanTransferNotification.LoanTransferNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanTransferNotification.LoanTransferNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanTransferNotification.LoanTransferNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanTransferNotification.LoanTransferNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanTransferNotification.LoanTransferNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanTransferNotification.LoanTransferNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanTransferNotification.LoanTransferNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transferEvent")
		public LoanTransferNotification.LoanTransferNotificationBuilder setTransferEvent(LoanTradeEvent transferEvent) {
			this.transferEvent = transferEvent==null?null:transferEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transfer")
		public LoanTransferNotification.LoanTransferNotificationBuilder setTransfer(LoanTransfer transfer) {
			this.transfer = transfer==null?null:transfer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanTransferNotification.LoanTransferNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public LoanTransferNotification.LoanTransferNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanTransferNotification.LoanTransferNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanTransferNotification.LoanTransferNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanTransferNotification.LoanTransferNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanTransferNotification build() {
			return new LoanTransferNotification.LoanTransferNotificationImpl(this);
		}
		
		@Override
		public LoanTransferNotification.LoanTransferNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferNotification.LoanTransferNotificationBuilder prune() {
			super.prune();
			if (transferEvent!=null && !transferEvent.prune().hasData()) transferEvent = null;
			if (transfer!=null && !transfer.prune().hasData()) transfer = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTransferEvent()!=null && getTransferEvent().hasData()) return true;
			if (getTransfer()!=null && getTransfer().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferNotification.LoanTransferNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTransferNotification.LoanTransferNotificationBuilder o = (LoanTransferNotification.LoanTransferNotificationBuilder) other;
			
			merger.mergeRosetta(getTransferEvent(), o.getTransferEvent(), this::setTransferEvent);
			merger.mergeRosetta(getTransfer(), o.getTransfer(), this::setTransfer);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTransferNotification _that = getType().cast(o);
		
			if (!Objects.equals(transferEvent, _that.getTransferEvent())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (transferEvent != null ? transferEvent.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferNotificationBuilder {" +
				"transferEvent=" + this.transferEvent + ", " +
				"transfer=" + this.transfer + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
