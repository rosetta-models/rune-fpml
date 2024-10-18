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
import fpml.confirmation.AbstractLoanPartyProfileNotification;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanPartyTradingInstructionOverrideNotification;
import fpml.confirmation.LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder;
import fpml.confirmation.LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilderImpl;
import fpml.confirmation.LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationImpl;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingInstructionOverride;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanPartyTradingInstructionOverrideNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A set of instructions communicated by parties to override standard payment details for a specific trade or allocation settlement only.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanPartyTradingInstructionOverrideNotification", builder=LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilderImpl.class, version="${project.version}")
public interface LoanPartyTradingInstructionOverrideNotification extends AbstractLoanPartyProfileNotification {

	LoanPartyTradingInstructionOverrideNotificationMeta metaData = new LoanPartyTradingInstructionOverrideNotificationMeta();

	/*********************** Getter Methods  ***********************/
	TradingInstructionOverride getOverride();
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
	LoanPartyTradingInstructionOverrideNotification build();
	
	LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder toBuilder();
	
	static LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder builder() {
		return new LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanPartyTradingInstructionOverrideNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanPartyTradingInstructionOverrideNotification> getType() {
		return LoanPartyTradingInstructionOverrideNotification.class;
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
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		processRosetta(path.newSubPath("override"), processor, TradingInstructionOverride.class, getOverride());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanPartyTradingInstructionOverrideNotificationBuilder extends LoanPartyTradingInstructionOverrideNotification, AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder {
		TradingInstructionOverride.TradingInstructionOverrideBuilder getOrCreateOverride();
		TradingInstructionOverride.TradingInstructionOverrideBuilder getOverride();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary();
		LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setActualBuild(Integer actualBuild);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setHeader(RequestMessageHeader header);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setComments(String comments);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setOverride(TradingInstructionOverride override);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder addParty(Party party0);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder addParty(Party party1, int _idx);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder addParty(List<? extends Party> party2);
		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setParty(List<? extends Party> party3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
			processRosetta(path.newSubPath("override"), processor, TradingInstructionOverride.TradingInstructionOverrideBuilder.class, getOverride());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanPartyTradingInstructionOverrideNotification  ***********************/
	class LoanPartyTradingInstructionOverrideNotificationImpl extends AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationImpl implements LoanPartyTradingInstructionOverrideNotification {
		private final TradingInstructionOverride override;
		private final LoanTradeSummary tradeSummary;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanPartyTradingInstructionOverrideNotificationImpl(LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder builder) {
			super(builder);
			this.override = ofNullable(builder.getOverride()).map(f->f.build()).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("override")
		public TradingInstructionOverride getOverride() {
			return override;
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
		public LoanPartyTradingInstructionOverrideNotification build() {
			return this;
		}
		
		@Override
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder toBuilder() {
			LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOverride()).ifPresent(builder::setOverride);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanPartyTradingInstructionOverrideNotification _that = getType().cast(o);
		
			if (!Objects.equals(override, _that.getOverride())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (override != null ? override.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPartyTradingInstructionOverrideNotification {" +
				"override=" + this.override + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanPartyTradingInstructionOverrideNotification  ***********************/
	class LoanPartyTradingInstructionOverrideNotificationBuilderImpl extends AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilderImpl  implements LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder {
	
		protected TradingInstructionOverride.TradingInstructionOverrideBuilder override;
		protected LoanTradeSummary.LoanTradeSummaryBuilder tradeSummary;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanPartyTradingInstructionOverrideNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("override")
		public TradingInstructionOverride.TradingInstructionOverrideBuilder getOverride() {
			return override;
		}
		
		@Override
		public TradingInstructionOverride.TradingInstructionOverrideBuilder getOrCreateOverride() {
			TradingInstructionOverride.TradingInstructionOverrideBuilder result;
			if (override!=null) {
				result = override;
			}
			else {
				result = override = TradingInstructionOverride.builder();
			}
			
			return result;
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
		
		@Override
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
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		@RosettaAttribute("override")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setOverride(TradingInstructionOverride override) {
			this.override = override==null?null:override.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary) {
			this.tradeSummary = tradeSummary==null?null:tradeSummary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanPartyTradingInstructionOverrideNotification build() {
			return new LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationImpl(this);
		}
		
		@Override
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder prune() {
			super.prune();
			if (override!=null && !override.prune().hasData()) override = null;
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOverride()!=null && getOverride().hasData()) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder o = (LoanPartyTradingInstructionOverrideNotification.LoanPartyTradingInstructionOverrideNotificationBuilder) other;
			
			merger.mergeRosetta(getOverride(), o.getOverride(), this::setOverride);
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
		
			LoanPartyTradingInstructionOverrideNotification _that = getType().cast(o);
		
			if (!Objects.equals(override, _that.getOverride())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (override != null ? override.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPartyTradingInstructionOverrideNotificationBuilder {" +
				"override=" + this.override + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
