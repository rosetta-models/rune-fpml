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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AveragingPeriod;
import fpml.confirmation.FxFeature;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.NotionalAdjustmentEnum;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Return;
import fpml.confirmation.ReturnLeg;
import fpml.confirmation.ReturnLeg.ReturnLegBuilder;
import fpml.confirmation.ReturnLeg.ReturnLegBuilderImpl;
import fpml.confirmation.ReturnLeg.ReturnLegImpl;
import fpml.confirmation.ReturnLegValuation;
import fpml.confirmation.ReturnSwapAmount;
import fpml.confirmation.ReturnSwapLegUnderlyer;
import fpml.confirmation.ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder;
import fpml.confirmation.ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilderImpl;
import fpml.confirmation.ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerImpl;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.ReturnLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Return amounts of the return type swap. A type describing the return leg of a return type swap.
 * @version ${project.version}
 */
@RosettaDataType(value="ReturnLeg", builder=ReturnLeg.ReturnLegBuilderImpl.class, version="${project.version}")
public interface ReturnLeg extends ReturnSwapLegUnderlyer {

	ReturnLegMeta metaData = new ReturnLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the terms of the initial price of the return type swap and of the subsequent valuations of the underlyer.
	 */
	ReturnLegValuation getRateOfReturn();
	/**
	 * Specifies the notional of a return type swap. When used in the equity leg, the definition will typically combine the actual amount (using the notional component defined by the FpML industry group) and the determination method. When used in the interest leg, the definition will typically point to the definition of the equity leg.
	 */
	ReturnSwapNotional getNotional();
	/**
	 * Specifies, in relation to each Payment Date, the amount to which the Payment Date relates. For return swaps this element is equivalent to the Equity Amount term as defined in the ISDA 2002 Equity Derivatives Definitions.
	 */
	ReturnSwapAmount getAmount();
	/**
	 * Specifies the conditions under which dividend affecting the underlyer will be paid to the receiver of the amounts.
	 */
	Return getReturn();
	/**
	 * Specifies the conditions that govern the adjustment to the number of units of the return swap.
	 */
	NotionalAdjustmentEnum getNotionalAdjustments();
	/**
	 * A quanto or composite FX feature.
	 */
	FxFeature getFxFeature();
	/**
	 * Averaging Dates used in the swap.
	 */
	AveragingPeriod getAveragingDates();

	/*********************** Build Methods  ***********************/
	ReturnLeg build();
	
	ReturnLeg.ReturnLegBuilder toBuilder();
	
	static ReturnLeg.ReturnLegBuilder builder() {
		return new ReturnLeg.ReturnLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnLeg> getType() {
		return ReturnLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("strikeDate"), processor, AdjustableOrRelativeDate.class, getStrikeDate());
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.class, getOptionSettlementModel());
		processRosetta(path.newSubPath("rateOfReturn"), processor, ReturnLegValuation.class, getRateOfReturn());
		processRosetta(path.newSubPath("notional"), processor, ReturnSwapNotional.class, getNotional());
		processRosetta(path.newSubPath("amount"), processor, ReturnSwapAmount.class, getAmount());
		processRosetta(path.newSubPath("return"), processor, Return.class, getReturn());
		processor.processBasic(path.newSubPath("notionalAdjustments"), NotionalAdjustmentEnum.class, getNotionalAdjustments(), this);
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("averagingDates"), processor, AveragingPeriod.class, getAveragingDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnLegBuilder extends ReturnLeg, ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder {
		ReturnLegValuation.ReturnLegValuationBuilder getOrCreateRateOfReturn();
		ReturnLegValuation.ReturnLegValuationBuilder getRateOfReturn();
		ReturnSwapNotional.ReturnSwapNotionalBuilder getOrCreateNotional();
		ReturnSwapNotional.ReturnSwapNotionalBuilder getNotional();
		ReturnSwapAmount.ReturnSwapAmountBuilder getOrCreateAmount();
		ReturnSwapAmount.ReturnSwapAmountBuilder getAmount();
		Return.ReturnBuilder getOrCreateReturn();
		Return.ReturnBuilder getReturn();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		FxFeature.FxFeatureBuilder getFxFeature();
		AveragingPeriod.AveragingPeriodBuilder getOrCreateAveragingDates();
		AveragingPeriod.AveragingPeriodBuilder getAveragingDates();
		ReturnLeg.ReturnLegBuilder setId(String id);
		ReturnLeg.ReturnLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		ReturnLeg.ReturnLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		ReturnLeg.ReturnLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		ReturnLeg.ReturnLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		ReturnLeg.ReturnLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		ReturnLeg.ReturnLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		ReturnLeg.ReturnLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		ReturnLeg.ReturnLegBuilder setStrikeDate(AdjustableOrRelativeDate strikeDate);
		ReturnLeg.ReturnLegBuilder setUnderlyer(Underlyer underlyer);
		ReturnLeg.ReturnLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);
		ReturnLeg.ReturnLegBuilder setRateOfReturn(ReturnLegValuation rateOfReturn);
		ReturnLeg.ReturnLegBuilder setNotional(ReturnSwapNotional notional);
		ReturnLeg.ReturnLegBuilder setAmount(ReturnSwapAmount amount);
		ReturnLeg.ReturnLegBuilder setReturn(Return _return);
		ReturnLeg.ReturnLegBuilder setNotionalAdjustments(NotionalAdjustmentEnum notionalAdjustments);
		ReturnLeg.ReturnLegBuilder setFxFeature(FxFeature fxFeature);
		ReturnLeg.ReturnLegBuilder setAveragingDates(AveragingPeriod averagingDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("strikeDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStrikeDate());
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.OptionSettlementModelBuilder.class, getOptionSettlementModel());
			processRosetta(path.newSubPath("rateOfReturn"), processor, ReturnLegValuation.ReturnLegValuationBuilder.class, getRateOfReturn());
			processRosetta(path.newSubPath("notional"), processor, ReturnSwapNotional.ReturnSwapNotionalBuilder.class, getNotional());
			processRosetta(path.newSubPath("amount"), processor, ReturnSwapAmount.ReturnSwapAmountBuilder.class, getAmount());
			processRosetta(path.newSubPath("return"), processor, Return.ReturnBuilder.class, getReturn());
			processor.processBasic(path.newSubPath("notionalAdjustments"), NotionalAdjustmentEnum.class, getNotionalAdjustments(), this);
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("averagingDates"), processor, AveragingPeriod.AveragingPeriodBuilder.class, getAveragingDates());
		}
		

		ReturnLeg.ReturnLegBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnLeg  ***********************/
	class ReturnLegImpl extends ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerImpl implements ReturnLeg {
		private final ReturnLegValuation rateOfReturn;
		private final ReturnSwapNotional notional;
		private final ReturnSwapAmount amount;
		private final Return _return;
		private final NotionalAdjustmentEnum notionalAdjustments;
		private final FxFeature fxFeature;
		private final AveragingPeriod averagingDates;
		
		protected ReturnLegImpl(ReturnLeg.ReturnLegBuilder builder) {
			super(builder);
			this.rateOfReturn = ofNullable(builder.getRateOfReturn()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this._return = ofNullable(builder.getReturn()).map(f->f.build()).orElse(null);
			this.notionalAdjustments = builder.getNotionalAdjustments();
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
			this.averagingDates = ofNullable(builder.getAveragingDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rateOfReturn")
		public ReturnLegValuation getRateOfReturn() {
			return rateOfReturn;
		}
		
		@Override
		@RosettaAttribute("notional")
		public ReturnSwapNotional getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("amount")
		public ReturnSwapAmount getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("return")
		public Return getReturn() {
			return _return;
		}
		
		@Override
		@RosettaAttribute("notionalAdjustments")
		public NotionalAdjustmentEnum getNotionalAdjustments() {
			return notionalAdjustments;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		@RosettaAttribute("averagingDates")
		public AveragingPeriod getAveragingDates() {
			return averagingDates;
		}
		
		@Override
		public ReturnLeg build() {
			return this;
		}
		
		@Override
		public ReturnLeg.ReturnLegBuilder toBuilder() {
			ReturnLeg.ReturnLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnLeg.ReturnLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRateOfReturn()).ifPresent(builder::setRateOfReturn);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getReturn()).ifPresent(builder::setReturn);
			ofNullable(getNotionalAdjustments()).ifPresent(builder::setNotionalAdjustments);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getAveragingDates()).ifPresent(builder::setAveragingDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnLeg _that = getType().cast(o);
		
			if (!Objects.equals(rateOfReturn, _that.getRateOfReturn())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(_return, _that.getReturn())) return false;
			if (!Objects.equals(notionalAdjustments, _that.getNotionalAdjustments())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(averagingDates, _that.getAveragingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rateOfReturn != null ? rateOfReturn.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (_return != null ? _return.hashCode() : 0);
			_result = 31 * _result + (notionalAdjustments != null ? notionalAdjustments.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (averagingDates != null ? averagingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLeg {" +
				"rateOfReturn=" + this.rateOfReturn + ", " +
				"notional=" + this.notional + ", " +
				"amount=" + this.amount + ", " +
				"return=" + this._return + ", " +
				"notionalAdjustments=" + this.notionalAdjustments + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"averagingDates=" + this.averagingDates +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnLeg  ***********************/
	class ReturnLegBuilderImpl extends ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilderImpl  implements ReturnLeg.ReturnLegBuilder {
	
		protected ReturnLegValuation.ReturnLegValuationBuilder rateOfReturn;
		protected ReturnSwapNotional.ReturnSwapNotionalBuilder notional;
		protected ReturnSwapAmount.ReturnSwapAmountBuilder amount;
		protected Return.ReturnBuilder _return;
		protected NotionalAdjustmentEnum notionalAdjustments;
		protected FxFeature.FxFeatureBuilder fxFeature;
		protected AveragingPeriod.AveragingPeriodBuilder averagingDates;
	
		public ReturnLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rateOfReturn")
		public ReturnLegValuation.ReturnLegValuationBuilder getRateOfReturn() {
			return rateOfReturn;
		}
		
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder getOrCreateRateOfReturn() {
			ReturnLegValuation.ReturnLegValuationBuilder result;
			if (rateOfReturn!=null) {
				result = rateOfReturn;
			}
			else {
				result = rateOfReturn = ReturnLegValuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notional")
		public ReturnSwapNotional.ReturnSwapNotionalBuilder getNotional() {
			return notional;
		}
		
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder getOrCreateNotional() {
			ReturnSwapNotional.ReturnSwapNotionalBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = ReturnSwapNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public ReturnSwapAmount.ReturnSwapAmountBuilder getAmount() {
			return amount;
		}
		
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder getOrCreateAmount() {
			ReturnSwapAmount.ReturnSwapAmountBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = ReturnSwapAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("return")
		public Return.ReturnBuilder getReturn() {
			return _return;
		}
		
		@Override
		public Return.ReturnBuilder getOrCreateReturn() {
			Return.ReturnBuilder result;
			if (_return!=null) {
				result = _return;
			}
			else {
				result = _return = Return.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAdjustments")
		public NotionalAdjustmentEnum getNotionalAdjustments() {
			return notionalAdjustments;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		public FxFeature.FxFeatureBuilder getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature() {
			FxFeature.FxFeatureBuilder result;
			if (fxFeature!=null) {
				result = fxFeature;
			}
			else {
				result = fxFeature = FxFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingDates")
		public AveragingPeriod.AveragingPeriodBuilder getAveragingDates() {
			return averagingDates;
		}
		
		@Override
		public AveragingPeriod.AveragingPeriodBuilder getOrCreateAveragingDates() {
			AveragingPeriod.AveragingPeriodBuilder result;
			if (averagingDates!=null) {
				result = averagingDates;
			}
			else {
				result = averagingDates = AveragingPeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public ReturnLeg.ReturnLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("legIdentifier")
		public ReturnLeg.ReturnLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ReturnLeg.ReturnLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public ReturnLeg.ReturnLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReturnLeg.ReturnLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null)  {
				this.legIdentifier = new ArrayList<>();
			}
			else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public ReturnLeg.ReturnLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public ReturnLeg.ReturnLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public ReturnLeg.ReturnLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikeDate")
		public ReturnLeg.ReturnLegBuilder setStrikeDate(AdjustableOrRelativeDate strikeDate) {
			this.strikeDate = strikeDate==null?null:strikeDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public ReturnLeg.ReturnLegBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public ReturnLeg.ReturnLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateOfReturn")
		public ReturnLeg.ReturnLegBuilder setRateOfReturn(ReturnLegValuation rateOfReturn) {
			this.rateOfReturn = rateOfReturn==null?null:rateOfReturn.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public ReturnLeg.ReturnLegBuilder setNotional(ReturnSwapNotional notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public ReturnLeg.ReturnLegBuilder setAmount(ReturnSwapAmount amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("return")
		public ReturnLeg.ReturnLegBuilder setReturn(Return _return) {
			this._return = _return==null?null:_return.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAdjustments")
		public ReturnLeg.ReturnLegBuilder setNotionalAdjustments(NotionalAdjustmentEnum notionalAdjustments) {
			this.notionalAdjustments = notionalAdjustments==null?null:notionalAdjustments;
			return this;
		}
		@Override
		@RosettaAttribute("fxFeature")
		public ReturnLeg.ReturnLegBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingDates")
		public ReturnLeg.ReturnLegBuilder setAveragingDates(AveragingPeriod averagingDates) {
			this.averagingDates = averagingDates==null?null:averagingDates.toBuilder();
			return this;
		}
		
		@Override
		public ReturnLeg build() {
			return new ReturnLeg.ReturnLegImpl(this);
		}
		
		@Override
		public ReturnLeg.ReturnLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLeg.ReturnLegBuilder prune() {
			super.prune();
			if (rateOfReturn!=null && !rateOfReturn.prune().hasData()) rateOfReturn = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (_return!=null && !_return.prune().hasData()) _return = null;
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			if (averagingDates!=null && !averagingDates.prune().hasData()) averagingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRateOfReturn()!=null && getRateOfReturn().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getReturn()!=null && getReturn().hasData()) return true;
			if (getNotionalAdjustments()!=null) return true;
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			if (getAveragingDates()!=null && getAveragingDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLeg.ReturnLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReturnLeg.ReturnLegBuilder o = (ReturnLeg.ReturnLegBuilder) other;
			
			merger.mergeRosetta(getRateOfReturn(), o.getRateOfReturn(), this::setRateOfReturn);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getReturn(), o.getReturn(), this::setReturn);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			merger.mergeRosetta(getAveragingDates(), o.getAveragingDates(), this::setAveragingDates);
			
			merger.mergeBasic(getNotionalAdjustments(), o.getNotionalAdjustments(), this::setNotionalAdjustments);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnLeg _that = getType().cast(o);
		
			if (!Objects.equals(rateOfReturn, _that.getRateOfReturn())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(_return, _that.getReturn())) return false;
			if (!Objects.equals(notionalAdjustments, _that.getNotionalAdjustments())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(averagingDates, _that.getAveragingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rateOfReturn != null ? rateOfReturn.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (_return != null ? _return.hashCode() : 0);
			_result = 31 * _result + (notionalAdjustments != null ? notionalAdjustments.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (averagingDates != null ? averagingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegBuilder {" +
				"rateOfReturn=" + this.rateOfReturn + ", " +
				"notional=" + this.notional + ", " +
				"amount=" + this.amount + ", " +
				"return=" + this._return + ", " +
				"notionalAdjustments=" + this.notionalAdjustments + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"averagingDates=" + this.averagingDates +
			'}' + " " + super.toString();
		}
	}
}
