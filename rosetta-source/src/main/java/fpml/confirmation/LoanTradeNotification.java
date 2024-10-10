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
import fpml.confirmation.LoanTrade;
import fpml.confirmation.LoanTradeEvent;
import fpml.confirmation.LoanTradeNotification;
import fpml.confirmation.LoanTradeNotification.LoanTradeNotificationBuilder;
import fpml.confirmation.LoanTradeNotification.LoanTradeNotificationBuilderImpl;
import fpml.confirmation.LoanTradeNotification.LoanTradeNotificationImpl;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanTradeNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate details to establish a master trade, from counterparty to counterparty.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradeNotification", builder=LoanTradeNotification.LoanTradeNotificationBuilderImpl.class, version="${project.version}")
public interface LoanTradeNotification extends AbstractLoanTradingNotification {

	LoanTradeNotificationMeta metaData = new LoanTradeNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to establish the loan trade event. This structure contains an event identifier for the trade as well as a reference to the details of the trade, contained in an element in the message.
	 */
	LoanTradeEvent getTradeEvent();
	/**
	 * A structure defining counterparty-to-counterparty loan trade information. This structure contains the main (e.g. fund manager/main counterparty) trade details.
	 */
	LoanTrade getTrade();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanTradeNotification build();
	
	LoanTradeNotification.LoanTradeNotificationBuilder toBuilder();
	
	static LoanTradeNotification.LoanTradeNotificationBuilder builder() {
		return new LoanTradeNotification.LoanTradeNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeNotification> getType() {
		return LoanTradeNotification.class;
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
		processRosetta(path.newSubPath("tradeEvent"), processor, LoanTradeEvent.class, getTradeEvent());
		processRosetta(path.newSubPath("trade"), processor, LoanTrade.class, getTrade());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeNotificationBuilder extends LoanTradeNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanTradeEvent.LoanTradeEventBuilder getOrCreateTradeEvent();
		LoanTradeEvent.LoanTradeEventBuilder getTradeEvent();
		LoanTrade.LoanTradeBuilder getOrCreateTrade();
		LoanTrade.LoanTradeBuilder getTrade();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanTradeNotification.LoanTradeNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanTradeNotification.LoanTradeNotificationBuilder setActualBuild(Integer actualBuild);
		LoanTradeNotification.LoanTradeNotificationBuilder setHeader(RequestMessageHeader header);
		LoanTradeNotification.LoanTradeNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanTradeNotification.LoanTradeNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanTradeNotification.LoanTradeNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanTradeNotification.LoanTradeNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanTradeNotification.LoanTradeNotificationBuilder setNoticeDate(Date noticeDate);
		LoanTradeNotification.LoanTradeNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanTradeNotification.LoanTradeNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanTradeNotification.LoanTradeNotificationBuilder setTradeEvent(LoanTradeEvent tradeEvent);
		LoanTradeNotification.LoanTradeNotificationBuilder setTrade(LoanTrade trade);
		LoanTradeNotification.LoanTradeNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LoanTradeNotification.LoanTradeNotificationBuilder addParty(Party party0);
		LoanTradeNotification.LoanTradeNotificationBuilder addParty(Party party1, int _idx);
		LoanTradeNotification.LoanTradeNotificationBuilder addParty(List<? extends Party> party2);
		LoanTradeNotification.LoanTradeNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("tradeEvent"), processor, LoanTradeEvent.LoanTradeEventBuilder.class, getTradeEvent());
			processRosetta(path.newSubPath("trade"), processor, LoanTrade.LoanTradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanTradeNotification.LoanTradeNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeNotification  ***********************/
	class LoanTradeNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanTradeNotification {
		private final LoanTradeEvent tradeEvent;
		private final LoanTrade trade;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanTradeNotificationImpl(LoanTradeNotification.LoanTradeNotificationBuilder builder) {
			super(builder);
			this.tradeEvent = ofNullable(builder.getTradeEvent()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeEvent")
		public LoanTradeEvent getTradeEvent() {
			return tradeEvent;
		}
		
		@Override
		@RosettaAttribute("trade")
		public LoanTrade getTrade() {
			return trade;
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
		public LoanTradeNotification build() {
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder toBuilder() {
			LoanTradeNotification.LoanTradeNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeNotification.LoanTradeNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeEvent()).ifPresent(builder::setTradeEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeNotification _that = getType().cast(o);
		
			if (!Objects.equals(tradeEvent, _that.getTradeEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeEvent != null ? tradeEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeNotification {" +
				"tradeEvent=" + this.tradeEvent + ", " +
				"trade=" + this.trade + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeNotification  ***********************/
	class LoanTradeNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanTradeNotification.LoanTradeNotificationBuilder {
	
		protected LoanTradeEvent.LoanTradeEventBuilder tradeEvent;
		protected LoanTrade.LoanTradeBuilder trade;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanTradeNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeEvent")
		public LoanTradeEvent.LoanTradeEventBuilder getTradeEvent() {
			return tradeEvent;
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder getOrCreateTradeEvent() {
			LoanTradeEvent.LoanTradeEventBuilder result;
			if (tradeEvent!=null) {
				result = tradeEvent;
			}
			else {
				result = tradeEvent = LoanTradeEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		public LoanTrade.LoanTradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public LoanTrade.LoanTradeBuilder getOrCreateTrade() {
			LoanTrade.LoanTradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = LoanTrade.builder();
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanTradeNotification.LoanTradeNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanTradeNotification.LoanTradeNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanTradeNotification.LoanTradeNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanTradeNotification.LoanTradeNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanTradeNotification.LoanTradeNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanTradeNotification.LoanTradeNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanTradeNotification.LoanTradeNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanTradeNotification.LoanTradeNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanTradeNotification.LoanTradeNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeEvent")
		public LoanTradeNotification.LoanTradeNotificationBuilder setTradeEvent(LoanTradeEvent tradeEvent) {
			this.tradeEvent = tradeEvent==null?null:tradeEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public LoanTradeNotification.LoanTradeNotificationBuilder setTrade(LoanTrade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanTradeNotification.LoanTradeNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeNotification.LoanTradeNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanTradeNotification.LoanTradeNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanTradeNotification build() {
			return new LoanTradeNotification.LoanTradeNotificationImpl(this);
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder prune() {
			super.prune();
			if (tradeEvent!=null && !tradeEvent.prune().hasData()) tradeEvent = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeEvent()!=null && getTradeEvent().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeNotification.LoanTradeNotificationBuilder o = (LoanTradeNotification.LoanTradeNotificationBuilder) other;
			
			merger.mergeRosetta(getTradeEvent(), o.getTradeEvent(), this::setTradeEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeNotification _that = getType().cast(o);
		
			if (!Objects.equals(tradeEvent, _that.getTradeEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeEvent != null ? tradeEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeNotificationBuilder {" +
				"tradeEvent=" + this.tradeEvent + ", " +
				"trade=" + this.trade + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
