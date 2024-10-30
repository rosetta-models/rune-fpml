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
import fpml.confirmation.ClearingEligibility;
import fpml.confirmation.ClearingEligibility.ClearingEligibilityBuilder;
import fpml.confirmation.ClearingEligibility.ClearingEligibilityBuilderImpl;
import fpml.confirmation.ClearingEligibility.ClearingEligibilityImpl;
import fpml.confirmation.ClearingRequirements;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.DeClear;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ClearingEligibilityMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ClearingEligibility", builder=ClearingEligibility.ClearingEligibilityBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ClearingEligibility extends ResponseMessage {

	ClearingEligibilityMeta metaData = new ClearingEligibilityMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsModel getTradingEventsModel();
	/**
	 * A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that it has been done.
	 */
	DeClear getDeClear();
	PartyTradeIdentifier getPartyTradeIdentifier();
	Boolean getEligibleForClearing();
	List<? extends ClearingRequirements> getClearingRequirements();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	ClearingEligibility build();
	
	ClearingEligibility.ClearingEligibilityBuilder toBuilder();
	
	static ClearingEligibility.ClearingEligibilityBuilder builder() {
		return new ClearingEligibility.ClearingEligibilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingEligibility> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingEligibility> getType() {
		return ClearingEligibility.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.class, getTradingEventsModel());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processor.processBasic(path.newSubPath("eligibleForClearing"), Boolean.class, getEligibleForClearing(), this);
		processRosetta(path.newSubPath("clearingRequirements"), processor, ClearingRequirements.class, getClearingRequirements());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingEligibilityBuilder extends ClearingEligibility, ResponseMessage.ResponseMessageBuilder {
		TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel();
		TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel();
		DeClear.DeClearBuilder getOrCreateDeClear();
		DeClear.DeClearBuilder getDeClear();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getPartyTradeIdentifier();
		ClearingRequirements.ClearingRequirementsBuilder getOrCreateClearingRequirements(int _index);
		List<? extends ClearingRequirements.ClearingRequirementsBuilder> getClearingRequirements();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		ClearingEligibility.ClearingEligibilityBuilder setExpectedBuild(Integer expectedBuild);
		ClearingEligibility.ClearingEligibilityBuilder setActualBuild(Integer actualBuild);
		ClearingEligibility.ClearingEligibilityBuilder setHeader(ResponseMessageHeader header);
		ClearingEligibility.ClearingEligibilityBuilder setValidationModel(ValidationModel validationModel);
		ClearingEligibility.ClearingEligibilityBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ClearingEligibility.ClearingEligibilityBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ClearingEligibility.ClearingEligibilityBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel);
		ClearingEligibility.ClearingEligibilityBuilder setDeClear(DeClear deClear);
		ClearingEligibility.ClearingEligibilityBuilder setPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		ClearingEligibility.ClearingEligibilityBuilder setEligibleForClearing(Boolean eligibleForClearing);
		ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(ClearingRequirements clearingRequirements0);
		ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(ClearingRequirements clearingRequirements1, int _idx);
		ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(List<? extends ClearingRequirements> clearingRequirements2);
		ClearingEligibility.ClearingEligibilityBuilder setClearingRequirements(List<? extends ClearingRequirements> clearingRequirements3);
		ClearingEligibility.ClearingEligibilityBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.TradingEventsModelBuilder.class, getTradingEventsModel());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processor.processBasic(path.newSubPath("eligibleForClearing"), Boolean.class, getEligibleForClearing(), this);
			processRosetta(path.newSubPath("clearingRequirements"), processor, ClearingRequirements.ClearingRequirementsBuilder.class, getClearingRequirements());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ClearingEligibility.ClearingEligibilityBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingEligibility  ***********************/
	class ClearingEligibilityImpl extends ResponseMessage.ResponseMessageImpl implements ClearingEligibility {
		private final TradingEventsModel tradingEventsModel;
		private final DeClear deClear;
		private final PartyTradeIdentifier partyTradeIdentifier;
		private final Boolean eligibleForClearing;
		private final List<? extends ClearingRequirements> clearingRequirements;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected ClearingEligibilityImpl(ClearingEligibility.ClearingEligibilityBuilder builder) {
			super(builder);
			this.tradingEventsModel = ofNullable(builder.getTradingEventsModel()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).map(f->f.build()).orElse(null);
			this.eligibleForClearing = builder.getEligibleForClearing();
			this.clearingRequirements = ofNullable(builder.getClearingRequirements()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel getTradingEventsModel() {
			return tradingEventsModel;
		}
		
		@Override
		@RosettaAttribute("deClear")
		public DeClear getDeClear() {
			return deClear;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public PartyTradeIdentifier getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("eligibleForClearing")
		public Boolean getEligibleForClearing() {
			return eligibleForClearing;
		}
		
		@Override
		@RosettaAttribute("clearingRequirements")
		public List<? extends ClearingRequirements> getClearingRequirements() {
			return clearingRequirements;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public ClearingEligibility build() {
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder toBuilder() {
			ClearingEligibility.ClearingEligibilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingEligibility.ClearingEligibilityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradingEventsModel()).ifPresent(builder::setTradingEventsModel);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getEligibleForClearing()).ifPresent(builder::setEligibleForClearing);
			ofNullable(getClearingRequirements()).ifPresent(builder::setClearingRequirements);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingEligibility _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!Objects.equals(eligibleForClearing, _that.getEligibleForClearing())) return false;
			if (!ListEquals.listEquals(clearingRequirements, _that.getClearingRequirements())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (eligibleForClearing != null ? eligibleForClearing.hashCode() : 0);
			_result = 31 * _result + (clearingRequirements != null ? clearingRequirements.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingEligibility {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"eligibleForClearing=" + this.eligibleForClearing + ", " +
				"clearingRequirements=" + this.clearingRequirements + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClearingEligibility  ***********************/
	class ClearingEligibilityBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl  implements ClearingEligibility.ClearingEligibilityBuilder {
	
		protected TradingEventsModel.TradingEventsModelBuilder tradingEventsModel;
		protected DeClear.DeClearBuilder deClear;
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder partyTradeIdentifier;
		protected Boolean eligibleForClearing;
		protected List<ClearingRequirements.ClearingRequirementsBuilder> clearingRequirements = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public ClearingEligibilityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel() {
			return tradingEventsModel;
		}
		
		@Override
		public TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel() {
			TradingEventsModel.TradingEventsModelBuilder result;
			if (tradingEventsModel!=null) {
				result = tradingEventsModel;
			}
			else {
				result = tradingEventsModel = TradingEventsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deClear")
		public DeClear.DeClearBuilder getDeClear() {
			return deClear;
		}
		
		@Override
		public DeClear.DeClearBuilder getOrCreateDeClear() {
			DeClear.DeClearBuilder result;
			if (deClear!=null) {
				result = deClear;
			}
			else {
				result = deClear = DeClear.builder();
			}
			
			return result;
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
		@RosettaAttribute("eligibleForClearing")
		public Boolean getEligibleForClearing() {
			return eligibleForClearing;
		}
		
		@Override
		@RosettaAttribute("clearingRequirements")
		public List<? extends ClearingRequirements.ClearingRequirementsBuilder> getClearingRequirements() {
			return clearingRequirements;
		}
		
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder getOrCreateClearingRequirements(int _index) {
		
			if (clearingRequirements==null) {
				this.clearingRequirements = new ArrayList<>();
			}
			ClearingRequirements.ClearingRequirementsBuilder result;
			return getIndex(clearingRequirements, _index, () -> {
						ClearingRequirements.ClearingRequirementsBuilder newClearingRequirements = ClearingRequirements.builder();
						return newClearingRequirements;
					});
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
		public ClearingEligibility.ClearingEligibilityBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ClearingEligibility.ClearingEligibilityBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ClearingEligibility.ClearingEligibilityBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ClearingEligibility.ClearingEligibilityBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ClearingEligibility.ClearingEligibilityBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ClearingEligibility.ClearingEligibilityBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsModel")
		public ClearingEligibility.ClearingEligibilityBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel) {
			this.tradingEventsModel = tradingEventsModel==null?null:tradingEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deClear")
		public ClearingEligibility.ClearingEligibilityBuilder setDeClear(DeClear deClear) {
			this.deClear = deClear==null?null:deClear.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public ClearingEligibility.ClearingEligibilityBuilder setPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier) {
			this.partyTradeIdentifier = partyTradeIdentifier==null?null:partyTradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eligibleForClearing")
		public ClearingEligibility.ClearingEligibilityBuilder setEligibleForClearing(Boolean eligibleForClearing) {
			this.eligibleForClearing = eligibleForClearing==null?null:eligibleForClearing;
			return this;
		}
		@Override
		@RosettaAttribute("clearingRequirements")
		public ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(ClearingRequirements clearingRequirements) {
			if (clearingRequirements!=null) this.clearingRequirements.add(clearingRequirements.toBuilder());
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(ClearingRequirements clearingRequirements, int _idx) {
			getIndex(this.clearingRequirements, _idx, () -> clearingRequirements.toBuilder());
			return this;
		}
		@Override 
		public ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(List<? extends ClearingRequirements> clearingRequirementss) {
			if (clearingRequirementss != null) {
				for (ClearingRequirements toAdd : clearingRequirementss) {
					this.clearingRequirements.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ClearingEligibility.ClearingEligibilityBuilder setClearingRequirements(List<? extends ClearingRequirements> clearingRequirementss) {
			if (clearingRequirementss == null)  {
				this.clearingRequirements = new ArrayList<>();
			}
			else {
				this.clearingRequirements = clearingRequirementss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ClearingEligibility.ClearingEligibilityBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ClearingEligibility build() {
			return new ClearingEligibility.ClearingEligibilityImpl(this);
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder prune() {
			super.prune();
			if (tradingEventsModel!=null && !tradingEventsModel.prune().hasData()) tradingEventsModel = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			if (partyTradeIdentifier!=null && !partyTradeIdentifier.prune().hasData()) partyTradeIdentifier = null;
			clearingRequirements = clearingRequirements.stream().filter(b->b!=null).<ClearingRequirements.ClearingRequirementsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradingEventsModel()!=null && getTradingEventsModel().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().hasData()) return true;
			if (getEligibleForClearing()!=null) return true;
			if (getClearingRequirements()!=null && getClearingRequirements().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ClearingEligibility.ClearingEligibilityBuilder o = (ClearingEligibility.ClearingEligibilityBuilder) other;
			
			merger.mergeRosetta(getTradingEventsModel(), o.getTradingEventsModel(), this::setTradingEventsModel);
			merger.mergeRosetta(getDeClear(), o.getDeClear(), this::setDeClear);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::setPartyTradeIdentifier);
			merger.mergeRosetta(getClearingRequirements(), o.getClearingRequirements(), this::getOrCreateClearingRequirements);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			merger.mergeBasic(getEligibleForClearing(), o.getEligibleForClearing(), this::setEligibleForClearing);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingEligibility _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!Objects.equals(eligibleForClearing, _that.getEligibleForClearing())) return false;
			if (!ListEquals.listEquals(clearingRequirements, _that.getClearingRequirements())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (eligibleForClearing != null ? eligibleForClearing.hashCode() : 0);
			_result = 31 * _result + (clearingRequirements != null ? clearingRequirements.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingEligibilityBuilder {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"eligibleForClearing=" + this.eligibleForClearing + ", " +
				"clearingRequirements=" + this.clearingRequirements + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
