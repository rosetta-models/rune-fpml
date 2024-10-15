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
import fpml.confirmation.LoanAllocation;
import fpml.confirmation.LoanAllocationEvent;
import fpml.confirmation.LoanAllocationNotification;
import fpml.confirmation.LoanAllocationNotification.LoanAllocationNotificationBuilder;
import fpml.confirmation.LoanAllocationNotification.LoanAllocationNotificationBuilderImpl;
import fpml.confirmation.LoanAllocationNotification.LoanAllocationNotificationImpl;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanAllocationNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate trade allocation details, from counterparty to counterparty, or counterparty to admin agent.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationNotification", builder=LoanAllocationNotification.LoanAllocationNotificationBuilderImpl.class, version="${project.version}")
public interface LoanAllocationNotification extends AbstractLoanTradingNotification {

	LoanAllocationNotificationMeta metaData = new LoanAllocationNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to establish the loan trade allocation event. This structure contains an event identifier for the allocation event as well as a reference to the details of the loan trade alloocation, contained in an element in the message.
	 */
	LoanAllocationEvent getAllocationEvent();
	/**
	 * A structure defining information related to a loan trade allocation.
	 */
	List<? extends LoanAllocation> getAllocation();
	/**
	 * A summary structure representing a loan trade.
	 */
	LoanTradeSummary getTradeSummary();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanAllocationNotification build();
	
	LoanAllocationNotification.LoanAllocationNotificationBuilder toBuilder();
	
	static LoanAllocationNotification.LoanAllocationNotificationBuilder builder() {
		return new LoanAllocationNotification.LoanAllocationNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationNotification> getType() {
		return LoanAllocationNotification.class;
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
		processRosetta(path.newSubPath("allocationEvent"), processor, LoanAllocationEvent.class, getAllocationEvent());
		processRosetta(path.newSubPath("allocation"), processor, LoanAllocation.class, getAllocation());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationNotificationBuilder extends LoanAllocationNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanAllocationEvent.LoanAllocationEventBuilder getOrCreateAllocationEvent();
		LoanAllocationEvent.LoanAllocationEventBuilder getAllocationEvent();
		LoanAllocation.LoanAllocationBuilder getOrCreateAllocation(int _index);
		List<? extends LoanAllocation.LoanAllocationBuilder> getAllocation();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary();
		LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanAllocationNotification.LoanAllocationNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setActualBuild(Integer actualBuild);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setHeader(RequestMessageHeader header);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setNoticeDate(Date noticeDate);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setAllocationEvent(LoanAllocationEvent allocationEvent);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addAllocation(LoanAllocation allocation0);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addAllocation(LoanAllocation allocation1, int _idx);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addAllocation(List<? extends LoanAllocation> allocation2);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setAllocation(List<? extends LoanAllocation> allocation3);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(Party party0);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(Party party1, int _idx);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(List<? extends Party> party2);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("allocationEvent"), processor, LoanAllocationEvent.LoanAllocationEventBuilder.class, getAllocationEvent());
			processRosetta(path.newSubPath("allocation"), processor, LoanAllocation.LoanAllocationBuilder.class, getAllocation());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanAllocationNotification.LoanAllocationNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationNotification  ***********************/
	class LoanAllocationNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanAllocationNotification {
		private final LoanAllocationEvent allocationEvent;
		private final List<? extends LoanAllocation> allocation;
		private final LoanTradeSummary tradeSummary;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanAllocationNotificationImpl(LoanAllocationNotification.LoanAllocationNotificationBuilder builder) {
			super(builder);
			this.allocationEvent = ofNullable(builder.getAllocationEvent()).map(f->f.build()).orElse(null);
			this.allocation = ofNullable(builder.getAllocation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationEvent")
		public LoanAllocationEvent getAllocationEvent() {
			return allocationEvent;
		}
		
		@Override
		@RosettaAttribute("allocation")
		public List<? extends LoanAllocation> getAllocation() {
			return allocation;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeSummary getTradeSummary() {
			return tradeSummary;
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
		public LoanAllocationNotification build() {
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder toBuilder() {
			LoanAllocationNotification.LoanAllocationNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationNotification.LoanAllocationNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAllocationEvent()).ifPresent(builder::setAllocationEvent);
			ofNullable(getAllocation()).ifPresent(builder::setAllocation);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationNotification _that = getType().cast(o);
		
			if (!Objects.equals(allocationEvent, _that.getAllocationEvent())) return false;
			if (!ListEquals.listEquals(allocation, _that.getAllocation())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationEvent != null ? allocationEvent.hashCode() : 0);
			_result = 31 * _result + (allocation != null ? allocation.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNotification {" +
				"allocationEvent=" + this.allocationEvent + ", " +
				"allocation=" + this.allocation + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationNotification  ***********************/
	class LoanAllocationNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanAllocationNotification.LoanAllocationNotificationBuilder {
	
		protected LoanAllocationEvent.LoanAllocationEventBuilder allocationEvent;
		protected List<LoanAllocation.LoanAllocationBuilder> allocation = new ArrayList<>();
		protected LoanTradeSummary.LoanTradeSummaryBuilder tradeSummary;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanAllocationNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocationEvent")
		public LoanAllocationEvent.LoanAllocationEventBuilder getAllocationEvent() {
			return allocationEvent;
		}
		
		@Override
		public LoanAllocationEvent.LoanAllocationEventBuilder getOrCreateAllocationEvent() {
			LoanAllocationEvent.LoanAllocationEventBuilder result;
			if (allocationEvent!=null) {
				result = allocationEvent;
			}
			else {
				result = allocationEvent = LoanAllocationEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocation")
		public List<? extends LoanAllocation.LoanAllocationBuilder> getAllocation() {
			return allocation;
		}
		
		public LoanAllocation.LoanAllocationBuilder getOrCreateAllocation(int _index) {
		
			if (allocation==null) {
				this.allocation = new ArrayList<>();
			}
			LoanAllocation.LoanAllocationBuilder result;
			return getIndex(allocation, _index, () -> {
						LoanAllocation.LoanAllocationBuilder newAllocation = LoanAllocation.builder();
						return newAllocation;
					});
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary() {
			LoanTradeSummary.LoanTradeSummaryBuilder result;
			if (tradeSummary!=null) {
				result = tradeSummary;
			}
			else {
				result = tradeSummary = LoanTradeSummary.builder();
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
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allocationEvent")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setAllocationEvent(LoanAllocationEvent allocationEvent) {
			this.allocationEvent = allocationEvent==null?null:allocationEvent.toBuilder();
			return this;
		}
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addAllocation(LoanAllocation allocation) {
			if (allocation!=null) this.allocation.add(allocation.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addAllocation(LoanAllocation allocation, int _idx) {
			getIndex(this.allocation, _idx, () -> allocation.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addAllocation(List<? extends LoanAllocation> allocations) {
			if (allocations != null) {
				for (LoanAllocation toAdd : allocations) {
					this.allocation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("allocation")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setAllocation(List<? extends LoanAllocation> allocations) {
			if (allocations == null)  {
				this.allocation = new ArrayList<>();
			}
			else {
				this.allocation = allocations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary) {
			this.tradeSummary = tradeSummary==null?null:tradeSummary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanAllocationNotification build() {
			return new LoanAllocationNotification.LoanAllocationNotificationImpl(this);
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder prune() {
			super.prune();
			if (allocationEvent!=null && !allocationEvent.prune().hasData()) allocationEvent = null;
			allocation = allocation.stream().filter(b->b!=null).<LoanAllocation.LoanAllocationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAllocationEvent()!=null && getAllocationEvent().hasData()) return true;
			if (getAllocation()!=null && getAllocation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationNotification.LoanAllocationNotificationBuilder o = (LoanAllocationNotification.LoanAllocationNotificationBuilder) other;
			
			merger.mergeRosetta(getAllocationEvent(), o.getAllocationEvent(), this::setAllocationEvent);
			merger.mergeRosetta(getAllocation(), o.getAllocation(), this::getOrCreateAllocation);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::setTradeSummary);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationNotification _that = getType().cast(o);
		
			if (!Objects.equals(allocationEvent, _that.getAllocationEvent())) return false;
			if (!ListEquals.listEquals(allocation, _that.getAllocation())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationEvent != null ? allocationEvent.hashCode() : 0);
			_result = 31 * _result + (allocation != null ? allocation.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNotificationBuilder {" +
				"allocationEvent=" + this.allocationEvent + ", " +
				"allocation=" + this.allocation + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
