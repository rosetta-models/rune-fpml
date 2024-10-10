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
import fpml.confirmation.ClearingStatusItem;
import fpml.confirmation.ClearingStatusItem.ClearingStatusItemBuilder;
import fpml.confirmation.ClearingStatusItem.ClearingStatusItemBuilderImpl;
import fpml.confirmation.ClearingStatusItem.ClearingStatusItemImpl;
import fpml.confirmation.ClearingStatusValue;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Reason;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradePackage;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.meta.ClearingStatusItemMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A component of a clearing status report. This provides the clearing status for a single trade.
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingStatusItem", builder=ClearingStatusItem.ClearingStatusItemBuilderImpl.class, version="${project.version}")
public interface ClearingStatusItem extends RosettaModelObject {

	ClearingStatusItemMeta metaData = new ClearingStatusItemMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifier(s) for the trade which is the subject of the clearing request to which this status relates.
	 */
	List<? extends TradeIdentifier> getTradeIdentifier();
	TradeReferenceInformationModel getTradeReferenceInformationModel();
	/**
	 * Complete economics of the trade
	 */
	Trade getTrade();
	TradePackage getTradePackage();
	/**
	 * The status of the clearing process for the identified trade. For example, Received, Pending (Approval), Registered (i.e. cleared), Rejected, etc.
	 */
	ClearingStatusValue getClearingStatusValue();
	/**
	 * When the clearing status changed to the current value. This is mostly useful if the clearing status messages could be delayed from when the status actually changes; this could be important if the status date is used as the basis of any settlement calculations.
	 */
	ZonedDateTime getUpdatedDateTime();
	/**
	 * Supporting information which may be produced to explain the clearing process status. This may be a business reason e.g. failed eligibility criteria for a trade in Rejected status.
	 */
	List<? extends Reason> getReason();
	/**
	 * Reference to parties currently in this status, e.g. parties for which we are awaiting approval. For example, if a trade is in &quot;Pending&quot; status, this would identify which parties&#39; approval the trade was pending.
	 */
	List<? extends PartyReference> getStatusAppliesTo();

	/*********************** Build Methods  ***********************/
	ClearingStatusItem build();
	
	ClearingStatusItem.ClearingStatusItemBuilder toBuilder();
	
	static ClearingStatusItem.ClearingStatusItemBuilder builder() {
		return new ClearingStatusItem.ClearingStatusItemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingStatusItem> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingStatusItem> getType() {
		return ClearingStatusItem.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.class, getTradeReferenceInformationModel());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.class, getTradePackage());
		processRosetta(path.newSubPath("clearingStatusValue"), processor, ClearingStatusValue.class, getClearingStatusValue());
		processor.processBasic(path.newSubPath("updatedDateTime"), ZonedDateTime.class, getUpdatedDateTime(), this);
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
		processRosetta(path.newSubPath("statusAppliesTo"), processor, PartyReference.class, getStatusAppliesTo());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingStatusItemBuilder extends ClearingStatusItem, RosettaModelObjectBuilder {
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel();
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		TradePackage.TradePackageBuilder getOrCreateTradePackage();
		TradePackage.TradePackageBuilder getTradePackage();
		ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatusValue();
		ClearingStatusValue.ClearingStatusValueBuilder getClearingStatusValue();
		Reason.ReasonBuilder getOrCreateReason(int _index);
		List<? extends Reason.ReasonBuilder> getReason();
		PartyReference.PartyReferenceBuilder getOrCreateStatusAppliesTo(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getStatusAppliesTo();
		ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier0);
		ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier1, int _idx);
		ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier2);
		ClearingStatusItem.ClearingStatusItemBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier3);
		ClearingStatusItem.ClearingStatusItemBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		ClearingStatusItem.ClearingStatusItemBuilder setTrade(Trade trade);
		ClearingStatusItem.ClearingStatusItemBuilder setTradePackage(TradePackage tradePackage);
		ClearingStatusItem.ClearingStatusItemBuilder setClearingStatusValue(ClearingStatusValue clearingStatusValue);
		ClearingStatusItem.ClearingStatusItemBuilder setUpdatedDateTime(ZonedDateTime updatedDateTime);
		ClearingStatusItem.ClearingStatusItemBuilder addReason(Reason reason0);
		ClearingStatusItem.ClearingStatusItemBuilder addReason(Reason reason1, int _idx);
		ClearingStatusItem.ClearingStatusItemBuilder addReason(List<? extends Reason> reason2);
		ClearingStatusItem.ClearingStatusItemBuilder setReason(List<? extends Reason> reason3);
		ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(PartyReference statusAppliesTo0);
		ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(PartyReference statusAppliesTo1, int _idx);
		ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(List<? extends PartyReference> statusAppliesTo2);
		ClearingStatusItem.ClearingStatusItemBuilder setStatusAppliesTo(List<? extends PartyReference> statusAppliesTo3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.TradeReferenceInformationModelBuilder.class, getTradeReferenceInformationModel());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.TradePackageBuilder.class, getTradePackage());
			processRosetta(path.newSubPath("clearingStatusValue"), processor, ClearingStatusValue.ClearingStatusValueBuilder.class, getClearingStatusValue());
			processor.processBasic(path.newSubPath("updatedDateTime"), ZonedDateTime.class, getUpdatedDateTime(), this);
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("statusAppliesTo"), processor, PartyReference.PartyReferenceBuilder.class, getStatusAppliesTo());
		}
		

		ClearingStatusItem.ClearingStatusItemBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingStatusItem  ***********************/
	class ClearingStatusItemImpl implements ClearingStatusItem {
		private final List<? extends TradeIdentifier> tradeIdentifier;
		private final TradeReferenceInformationModel tradeReferenceInformationModel;
		private final Trade trade;
		private final TradePackage tradePackage;
		private final ClearingStatusValue clearingStatusValue;
		private final ZonedDateTime updatedDateTime;
		private final List<? extends Reason> reason;
		private final List<? extends PartyReference> statusAppliesTo;
		
		protected ClearingStatusItemImpl(ClearingStatusItem.ClearingStatusItemBuilder builder) {
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeReferenceInformationModel = ofNullable(builder.getTradeReferenceInformationModel()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.tradePackage = ofNullable(builder.getTradePackage()).map(f->f.build()).orElse(null);
			this.clearingStatusValue = ofNullable(builder.getClearingStatusValue()).map(f->f.build()).orElse(null);
			this.updatedDateTime = builder.getUpdatedDateTime();
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.statusAppliesTo = ofNullable(builder.getStatusAppliesTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		public TradePackage getTradePackage() {
			return tradePackage;
		}
		
		@Override
		@RosettaAttribute("clearingStatusValue")
		public ClearingStatusValue getClearingStatusValue() {
			return clearingStatusValue;
		}
		
		@Override
		@RosettaAttribute("updatedDateTime")
		public ZonedDateTime getUpdatedDateTime() {
			return updatedDateTime;
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("statusAppliesTo")
		public List<? extends PartyReference> getStatusAppliesTo() {
			return statusAppliesTo;
		}
		
		@Override
		public ClearingStatusItem build() {
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder toBuilder() {
			ClearingStatusItem.ClearingStatusItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingStatusItem.ClearingStatusItemBuilder builder) {
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getTradeReferenceInformationModel()).ifPresent(builder::setTradeReferenceInformationModel);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradePackage()).ifPresent(builder::setTradePackage);
			ofNullable(getClearingStatusValue()).ifPresent(builder::setClearingStatusValue);
			ofNullable(getUpdatedDateTime()).ifPresent(builder::setUpdatedDateTime);
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getStatusAppliesTo()).ifPresent(builder::setStatusAppliesTo);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingStatusItem _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(clearingStatusValue, _that.getClearingStatusValue())) return false;
			if (!Objects.equals(updatedDateTime, _that.getUpdatedDateTime())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(statusAppliesTo, _that.getStatusAppliesTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (clearingStatusValue != null ? clearingStatusValue.hashCode() : 0);
			_result = 31 * _result + (updatedDateTime != null ? updatedDateTime.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (statusAppliesTo != null ? statusAppliesTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatusItem {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"trade=" + this.trade + ", " +
				"tradePackage=" + this.tradePackage + ", " +
				"clearingStatusValue=" + this.clearingStatusValue + ", " +
				"updatedDateTime=" + this.updatedDateTime + ", " +
				"reason=" + this.reason + ", " +
				"statusAppliesTo=" + this.statusAppliesTo +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingStatusItem  ***********************/
	class ClearingStatusItemBuilderImpl implements ClearingStatusItem.ClearingStatusItemBuilder {
	
		protected List<TradeIdentifier.TradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected TradeReferenceInformationModel.TradeReferenceInformationModelBuilder tradeReferenceInformationModel;
		protected Trade.TradeBuilder trade;
		protected TradePackage.TradePackageBuilder tradePackage;
		protected ClearingStatusValue.ClearingStatusValueBuilder clearingStatusValue;
		protected ZonedDateTime updatedDateTime;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		protected List<PartyReference.PartyReferenceBuilder> statusAppliesTo = new ArrayList<>();
	
		public ClearingStatusItemBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			TradeIdentifier.TradeIdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newTradeIdentifier = TradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel() {
			TradeReferenceInformationModel.TradeReferenceInformationModelBuilder result;
			if (tradeReferenceInformationModel!=null) {
				result = tradeReferenceInformationModel;
			}
			else {
				result = tradeReferenceInformationModel = TradeReferenceInformationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		public TradePackage.TradePackageBuilder getTradePackage() {
			return tradePackage;
		}
		
		@Override
		public TradePackage.TradePackageBuilder getOrCreateTradePackage() {
			TradePackage.TradePackageBuilder result;
			if (tradePackage!=null) {
				result = tradePackage;
			}
			else {
				result = tradePackage = TradePackage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearingStatusValue")
		public ClearingStatusValue.ClearingStatusValueBuilder getClearingStatusValue() {
			return clearingStatusValue;
		}
		
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatusValue() {
			ClearingStatusValue.ClearingStatusValueBuilder result;
			if (clearingStatusValue!=null) {
				result = clearingStatusValue;
			}
			else {
				result = clearingStatusValue = ClearingStatusValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("updatedDateTime")
		public ZonedDateTime getUpdatedDateTime() {
			return updatedDateTime;
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
		@RosettaAttribute("statusAppliesTo")
		public List<? extends PartyReference.PartyReferenceBuilder> getStatusAppliesTo() {
			return statusAppliesTo;
		}
		
		public PartyReference.PartyReferenceBuilder getOrCreateStatusAppliesTo(int _index) {
		
			if (statusAppliesTo==null) {
				this.statusAppliesTo = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(statusAppliesTo, _index, () -> {
						PartyReference.PartyReferenceBuilder newStatusAppliesTo = PartyReference.builder();
						return newStatusAppliesTo;
					});
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (TradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("tradeIdentifier")
		public ClearingStatusItem.ClearingStatusItemBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null)  {
				this.tradeIdentifier = new ArrayList<>();
			}
			else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public ClearingStatusItem.ClearingStatusItemBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public ClearingStatusItem.ClearingStatusItemBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradePackage")
		public ClearingStatusItem.ClearingStatusItemBuilder setTradePackage(TradePackage tradePackage) {
			this.tradePackage = tradePackage==null?null:tradePackage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearingStatusValue")
		public ClearingStatusItem.ClearingStatusItemBuilder setClearingStatusValue(ClearingStatusValue clearingStatusValue) {
			this.clearingStatusValue = clearingStatusValue==null?null:clearingStatusValue.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("updatedDateTime")
		public ClearingStatusItem.ClearingStatusItemBuilder setUpdatedDateTime(ZonedDateTime updatedDateTime) {
			this.updatedDateTime = updatedDateTime==null?null:updatedDateTime;
			return this;
		}
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addReason(Reason reason) {
			if (reason!=null) this.reason.add(reason.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addReason(Reason reason, int _idx) {
			getIndex(this.reason, _idx, () -> reason.toBuilder());
			return this;
		}
		@Override 
		public ClearingStatusItem.ClearingStatusItemBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reason")
		public ClearingStatusItem.ClearingStatusItemBuilder setReason(List<? extends Reason> reasons) {
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
		public ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(PartyReference statusAppliesTo) {
			if (statusAppliesTo!=null) this.statusAppliesTo.add(statusAppliesTo.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(PartyReference statusAppliesTo, int _idx) {
			getIndex(this.statusAppliesTo, _idx, () -> statusAppliesTo.toBuilder());
			return this;
		}
		@Override 
		public ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(List<? extends PartyReference> statusAppliesTos) {
			if (statusAppliesTos != null) {
				for (PartyReference toAdd : statusAppliesTos) {
					this.statusAppliesTo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("statusAppliesTo")
		public ClearingStatusItem.ClearingStatusItemBuilder setStatusAppliesTo(List<? extends PartyReference> statusAppliesTos) {
			if (statusAppliesTos == null)  {
				this.statusAppliesTo = new ArrayList<>();
			}
			else {
				this.statusAppliesTo = statusAppliesTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ClearingStatusItem build() {
			return new ClearingStatusItem.ClearingStatusItemImpl(this);
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder prune() {
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeReferenceInformationModel!=null && !tradeReferenceInformationModel.prune().hasData()) tradeReferenceInformationModel = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (tradePackage!=null && !tradePackage.prune().hasData()) tradePackage = null;
			if (clearingStatusValue!=null && !clearingStatusValue.prune().hasData()) clearingStatusValue = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			statusAppliesTo = statusAppliesTo.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeReferenceInformationModel()!=null && getTradeReferenceInformationModel().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getTradePackage()!=null && getTradePackage().hasData()) return true;
			if (getClearingStatusValue()!=null && getClearingStatusValue().hasData()) return true;
			if (getUpdatedDateTime()!=null) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getStatusAppliesTo()!=null && getStatusAppliesTo().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingStatusItem.ClearingStatusItemBuilder o = (ClearingStatusItem.ClearingStatusItemBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getTradeReferenceInformationModel(), o.getTradeReferenceInformationModel(), this::setTradeReferenceInformationModel);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getTradePackage(), o.getTradePackage(), this::setTradePackage);
			merger.mergeRosetta(getClearingStatusValue(), o.getClearingStatusValue(), this::setClearingStatusValue);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			merger.mergeRosetta(getStatusAppliesTo(), o.getStatusAppliesTo(), this::getOrCreateStatusAppliesTo);
			
			merger.mergeBasic(getUpdatedDateTime(), o.getUpdatedDateTime(), this::setUpdatedDateTime);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingStatusItem _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(clearingStatusValue, _that.getClearingStatusValue())) return false;
			if (!Objects.equals(updatedDateTime, _that.getUpdatedDateTime())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(statusAppliesTo, _that.getStatusAppliesTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (clearingStatusValue != null ? clearingStatusValue.hashCode() : 0);
			_result = 31 * _result + (updatedDateTime != null ? updatedDateTime.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (statusAppliesTo != null ? statusAppliesTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatusItemBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"trade=" + this.trade + ", " +
				"tradePackage=" + this.tradePackage + ", " +
				"clearingStatusValue=" + this.clearingStatusValue + ", " +
				"updatedDateTime=" + this.updatedDateTime + ", " +
				"reason=" + this.reason + ", " +
				"statusAppliesTo=" + this.statusAppliesTo +
			'}';
		}
	}
}
