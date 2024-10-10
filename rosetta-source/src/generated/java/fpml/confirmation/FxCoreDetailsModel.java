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
import fpml.confirmation.DealtCurrencyEnum;
import fpml.confirmation.ExchangeRate;
import fpml.confirmation.FxCashSettlement;
import fpml.confirmation.FxCoreDetailsModel;
import fpml.confirmation.FxCoreDetailsModel.FxCoreDetailsModelBuilder;
import fpml.confirmation.FxCoreDetailsModel.FxCoreDetailsModelBuilderImpl;
import fpml.confirmation.FxCoreDetailsModel.FxCoreDetailsModelImpl;
import fpml.confirmation.FxCoreDetailsModelSequence;
import fpml.confirmation.FxDisruption;
import fpml.confirmation.FxTenorModel;
import fpml.confirmation.Payment;
import fpml.confirmation.meta.FxCoreDetailsModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The elements common to FX spot, forward and swap legs.
 * @version ${project.version}
 */
@RosettaDataType(value="FxCoreDetailsModel", builder=FxCoreDetailsModel.FxCoreDetailsModelBuilderImpl.class, version="${project.version}")
public interface FxCoreDetailsModel extends RosettaModelObject {

	FxCoreDetailsModelMeta metaData = new FxCoreDetailsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This is the first of the two currency flows that define a single leg of a standard foreign exchange transaction.
	 */
	Payment getExchangedCurrency1();
	/**
	 * This is the second of the two currency flows that define a single leg of a standard foreign exchange transaction.
	 */
	Payment getExchangedCurrency2();
	/**
	 * Indicates which currency was dealt.
	 */
	DealtCurrencyEnum getDealtCurrency();
	FxTenorModel getFxTenorModel();
	/**
	 * The date on which both currencies traded will settle.
	 */
	Date getValueDate();
	FxCoreDetailsModelSequence getFxCoreDetailsModelSequence();
	/**
	 * The rate of exchange between the two currencies.
	 */
	ExchangeRate getExchangeRate();
	/**
	 * Used to describe a particular type of FX forward transaction that is settled in a single currency (for example, a non-deliverable forward).
	 */
	FxCashSettlement getNonDeliverableSettlement();
	/**
	 * Describes the disruption events and fallbacks applicable to a currency pair referenced by the transaction.
	 */
	List<? extends FxDisruption> getDisruption();

	/*********************** Build Methods  ***********************/
	FxCoreDetailsModel build();
	
	FxCoreDetailsModel.FxCoreDetailsModelBuilder toBuilder();
	
	static FxCoreDetailsModel.FxCoreDetailsModelBuilder builder() {
		return new FxCoreDetailsModel.FxCoreDetailsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCoreDetailsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxCoreDetailsModel> getType() {
		return FxCoreDetailsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("exchangedCurrency1"), processor, Payment.class, getExchangedCurrency1());
		processRosetta(path.newSubPath("exchangedCurrency2"), processor, Payment.class, getExchangedCurrency2());
		processor.processBasic(path.newSubPath("dealtCurrency"), DealtCurrencyEnum.class, getDealtCurrency(), this);
		processRosetta(path.newSubPath("fxTenorModel"), processor, FxTenorModel.class, getFxTenorModel());
		processor.processBasic(path.newSubPath("valueDate"), Date.class, getValueDate(), this);
		processRosetta(path.newSubPath("fxCoreDetailsModelSequence"), processor, FxCoreDetailsModelSequence.class, getFxCoreDetailsModelSequence());
		processRosetta(path.newSubPath("exchangeRate"), processor, ExchangeRate.class, getExchangeRate());
		processRosetta(path.newSubPath("nonDeliverableSettlement"), processor, FxCashSettlement.class, getNonDeliverableSettlement());
		processRosetta(path.newSubPath("disruption"), processor, FxDisruption.class, getDisruption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCoreDetailsModelBuilder extends FxCoreDetailsModel, RosettaModelObjectBuilder {
		Payment.PaymentBuilder getOrCreateExchangedCurrency1();
		Payment.PaymentBuilder getExchangedCurrency1();
		Payment.PaymentBuilder getOrCreateExchangedCurrency2();
		Payment.PaymentBuilder getExchangedCurrency2();
		FxTenorModel.FxTenorModelBuilder getOrCreateFxTenorModel();
		FxTenorModel.FxTenorModelBuilder getFxTenorModel();
		FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder getOrCreateFxCoreDetailsModelSequence();
		FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder getFxCoreDetailsModelSequence();
		ExchangeRate.ExchangeRateBuilder getOrCreateExchangeRate();
		ExchangeRate.ExchangeRateBuilder getExchangeRate();
		FxCashSettlement.FxCashSettlementBuilder getOrCreateNonDeliverableSettlement();
		FxCashSettlement.FxCashSettlementBuilder getNonDeliverableSettlement();
		FxDisruption.FxDisruptionBuilder getOrCreateDisruption(int _index);
		List<? extends FxDisruption.FxDisruptionBuilder> getDisruption();
		FxCoreDetailsModel.FxCoreDetailsModelBuilder setExchangedCurrency1(Payment exchangedCurrency1);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder setExchangedCurrency2(Payment exchangedCurrency2);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder setDealtCurrency(DealtCurrencyEnum dealtCurrency);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder setFxTenorModel(FxTenorModel fxTenorModel);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder setValueDate(Date valueDate);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder setFxCoreDetailsModelSequence(FxCoreDetailsModelSequence fxCoreDetailsModelSequence);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder setExchangeRate(ExchangeRate exchangeRate);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder setNonDeliverableSettlement(FxCashSettlement nonDeliverableSettlement);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder addDisruption(FxDisruption disruption0);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder addDisruption(FxDisruption disruption1, int _idx);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder addDisruption(List<? extends FxDisruption> disruption2);
		FxCoreDetailsModel.FxCoreDetailsModelBuilder setDisruption(List<? extends FxDisruption> disruption3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("exchangedCurrency1"), processor, Payment.PaymentBuilder.class, getExchangedCurrency1());
			processRosetta(path.newSubPath("exchangedCurrency2"), processor, Payment.PaymentBuilder.class, getExchangedCurrency2());
			processor.processBasic(path.newSubPath("dealtCurrency"), DealtCurrencyEnum.class, getDealtCurrency(), this);
			processRosetta(path.newSubPath("fxTenorModel"), processor, FxTenorModel.FxTenorModelBuilder.class, getFxTenorModel());
			processor.processBasic(path.newSubPath("valueDate"), Date.class, getValueDate(), this);
			processRosetta(path.newSubPath("fxCoreDetailsModelSequence"), processor, FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder.class, getFxCoreDetailsModelSequence());
			processRosetta(path.newSubPath("exchangeRate"), processor, ExchangeRate.ExchangeRateBuilder.class, getExchangeRate());
			processRosetta(path.newSubPath("nonDeliverableSettlement"), processor, FxCashSettlement.FxCashSettlementBuilder.class, getNonDeliverableSettlement());
			processRosetta(path.newSubPath("disruption"), processor, FxDisruption.FxDisruptionBuilder.class, getDisruption());
		}
		

		FxCoreDetailsModel.FxCoreDetailsModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxCoreDetailsModel  ***********************/
	class FxCoreDetailsModelImpl implements FxCoreDetailsModel {
		private final Payment exchangedCurrency1;
		private final Payment exchangedCurrency2;
		private final DealtCurrencyEnum dealtCurrency;
		private final FxTenorModel fxTenorModel;
		private final Date valueDate;
		private final FxCoreDetailsModelSequence fxCoreDetailsModelSequence;
		private final ExchangeRate exchangeRate;
		private final FxCashSettlement nonDeliverableSettlement;
		private final List<? extends FxDisruption> disruption;
		
		protected FxCoreDetailsModelImpl(FxCoreDetailsModel.FxCoreDetailsModelBuilder builder) {
			this.exchangedCurrency1 = ofNullable(builder.getExchangedCurrency1()).map(f->f.build()).orElse(null);
			this.exchangedCurrency2 = ofNullable(builder.getExchangedCurrency2()).map(f->f.build()).orElse(null);
			this.dealtCurrency = builder.getDealtCurrency();
			this.fxTenorModel = ofNullable(builder.getFxTenorModel()).map(f->f.build()).orElse(null);
			this.valueDate = builder.getValueDate();
			this.fxCoreDetailsModelSequence = ofNullable(builder.getFxCoreDetailsModelSequence()).map(f->f.build()).orElse(null);
			this.exchangeRate = ofNullable(builder.getExchangeRate()).map(f->f.build()).orElse(null);
			this.nonDeliverableSettlement = ofNullable(builder.getNonDeliverableSettlement()).map(f->f.build()).orElse(null);
			this.disruption = ofNullable(builder.getDisruption()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		public Payment getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		public Payment getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		@RosettaAttribute("dealtCurrency")
		public DealtCurrencyEnum getDealtCurrency() {
			return dealtCurrency;
		}
		
		@Override
		@RosettaAttribute("fxTenorModel")
		public FxTenorModel getFxTenorModel() {
			return fxTenorModel;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		public Date getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("fxCoreDetailsModelSequence")
		public FxCoreDetailsModelSequence getFxCoreDetailsModelSequence() {
			return fxCoreDetailsModelSequence;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		public ExchangeRate getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		@RosettaAttribute("nonDeliverableSettlement")
		public FxCashSettlement getNonDeliverableSettlement() {
			return nonDeliverableSettlement;
		}
		
		@Override
		@RosettaAttribute("disruption")
		public List<? extends FxDisruption> getDisruption() {
			return disruption;
		}
		
		@Override
		public FxCoreDetailsModel build() {
			return this;
		}
		
		@Override
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder toBuilder() {
			FxCoreDetailsModel.FxCoreDetailsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCoreDetailsModel.FxCoreDetailsModelBuilder builder) {
			ofNullable(getExchangedCurrency1()).ifPresent(builder::setExchangedCurrency1);
			ofNullable(getExchangedCurrency2()).ifPresent(builder::setExchangedCurrency2);
			ofNullable(getDealtCurrency()).ifPresent(builder::setDealtCurrency);
			ofNullable(getFxTenorModel()).ifPresent(builder::setFxTenorModel);
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
			ofNullable(getFxCoreDetailsModelSequence()).ifPresent(builder::setFxCoreDetailsModelSequence);
			ofNullable(getExchangeRate()).ifPresent(builder::setExchangeRate);
			ofNullable(getNonDeliverableSettlement()).ifPresent(builder::setNonDeliverableSettlement);
			ofNullable(getDisruption()).ifPresent(builder::setDisruption);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCoreDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			if (!Objects.equals(dealtCurrency, _that.getDealtCurrency())) return false;
			if (!Objects.equals(fxTenorModel, _that.getFxTenorModel())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!Objects.equals(fxCoreDetailsModelSequence, _that.getFxCoreDetailsModelSequence())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(nonDeliverableSettlement, _that.getNonDeliverableSettlement())) return false;
			if (!ListEquals.listEquals(disruption, _that.getDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			_result = 31 * _result + (dealtCurrency != null ? dealtCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxTenorModel != null ? fxTenorModel.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (fxCoreDetailsModelSequence != null ? fxCoreDetailsModelSequence.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSettlement != null ? nonDeliverableSettlement.hashCode() : 0);
			_result = 31 * _result + (disruption != null ? disruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCoreDetailsModel {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 + ", " +
				"dealtCurrency=" + this.dealtCurrency + ", " +
				"fxTenorModel=" + this.fxTenorModel + ", " +
				"valueDate=" + this.valueDate + ", " +
				"fxCoreDetailsModelSequence=" + this.fxCoreDetailsModelSequence + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"nonDeliverableSettlement=" + this.nonDeliverableSettlement + ", " +
				"disruption=" + this.disruption +
			'}';
		}
	}

	/*********************** Builder Implementation of FxCoreDetailsModel  ***********************/
	class FxCoreDetailsModelBuilderImpl implements FxCoreDetailsModel.FxCoreDetailsModelBuilder {
	
		protected Payment.PaymentBuilder exchangedCurrency1;
		protected Payment.PaymentBuilder exchangedCurrency2;
		protected DealtCurrencyEnum dealtCurrency;
		protected FxTenorModel.FxTenorModelBuilder fxTenorModel;
		protected Date valueDate;
		protected FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder fxCoreDetailsModelSequence;
		protected ExchangeRate.ExchangeRateBuilder exchangeRate;
		protected FxCashSettlement.FxCashSettlementBuilder nonDeliverableSettlement;
		protected List<FxDisruption.FxDisruptionBuilder> disruption = new ArrayList<>();
	
		public FxCoreDetailsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exchangedCurrency1")
		public Payment.PaymentBuilder getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateExchangedCurrency1() {
			Payment.PaymentBuilder result;
			if (exchangedCurrency1!=null) {
				result = exchangedCurrency1;
			}
			else {
				result = exchangedCurrency1 = Payment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		public Payment.PaymentBuilder getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateExchangedCurrency2() {
			Payment.PaymentBuilder result;
			if (exchangedCurrency2!=null) {
				result = exchangedCurrency2;
			}
			else {
				result = exchangedCurrency2 = Payment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealtCurrency")
		public DealtCurrencyEnum getDealtCurrency() {
			return dealtCurrency;
		}
		
		@Override
		@RosettaAttribute("fxTenorModel")
		public FxTenorModel.FxTenorModelBuilder getFxTenorModel() {
			return fxTenorModel;
		}
		
		@Override
		public FxTenorModel.FxTenorModelBuilder getOrCreateFxTenorModel() {
			FxTenorModel.FxTenorModelBuilder result;
			if (fxTenorModel!=null) {
				result = fxTenorModel;
			}
			else {
				result = fxTenorModel = FxTenorModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		public Date getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("fxCoreDetailsModelSequence")
		public FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder getFxCoreDetailsModelSequence() {
			return fxCoreDetailsModelSequence;
		}
		
		@Override
		public FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder getOrCreateFxCoreDetailsModelSequence() {
			FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder result;
			if (fxCoreDetailsModelSequence!=null) {
				result = fxCoreDetailsModelSequence;
			}
			else {
				result = fxCoreDetailsModelSequence = FxCoreDetailsModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		public ExchangeRate.ExchangeRateBuilder getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		public ExchangeRate.ExchangeRateBuilder getOrCreateExchangeRate() {
			ExchangeRate.ExchangeRateBuilder result;
			if (exchangeRate!=null) {
				result = exchangeRate;
			}
			else {
				result = exchangeRate = ExchangeRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonDeliverableSettlement")
		public FxCashSettlement.FxCashSettlementBuilder getNonDeliverableSettlement() {
			return nonDeliverableSettlement;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder getOrCreateNonDeliverableSettlement() {
			FxCashSettlement.FxCashSettlementBuilder result;
			if (nonDeliverableSettlement!=null) {
				result = nonDeliverableSettlement;
			}
			else {
				result = nonDeliverableSettlement = FxCashSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("disruption")
		public List<? extends FxDisruption.FxDisruptionBuilder> getDisruption() {
			return disruption;
		}
		
		public FxDisruption.FxDisruptionBuilder getOrCreateDisruption(int _index) {
		
			if (disruption==null) {
				this.disruption = new ArrayList<>();
			}
			FxDisruption.FxDisruptionBuilder result;
			return getIndex(disruption, _index, () -> {
						FxDisruption.FxDisruptionBuilder newDisruption = FxDisruption.builder();
						return newDisruption;
					});
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder setExchangedCurrency1(Payment exchangedCurrency1) {
			this.exchangedCurrency1 = exchangedCurrency1==null?null:exchangedCurrency1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangedCurrency2")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder setExchangedCurrency2(Payment exchangedCurrency2) {
			this.exchangedCurrency2 = exchangedCurrency2==null?null:exchangedCurrency2.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dealtCurrency")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder setDealtCurrency(DealtCurrencyEnum dealtCurrency) {
			this.dealtCurrency = dealtCurrency==null?null:dealtCurrency;
			return this;
		}
		@Override
		@RosettaAttribute("fxTenorModel")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder setFxTenorModel(FxTenorModel fxTenorModel) {
			this.fxTenorModel = fxTenorModel==null?null:fxTenorModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valueDate")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder setValueDate(Date valueDate) {
			this.valueDate = valueDate==null?null:valueDate;
			return this;
		}
		@Override
		@RosettaAttribute("fxCoreDetailsModelSequence")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder setFxCoreDetailsModelSequence(FxCoreDetailsModelSequence fxCoreDetailsModelSequence) {
			this.fxCoreDetailsModelSequence = fxCoreDetailsModelSequence==null?null:fxCoreDetailsModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeRate")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder setExchangeRate(ExchangeRate exchangeRate) {
			this.exchangeRate = exchangeRate==null?null:exchangeRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("nonDeliverableSettlement")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder setNonDeliverableSettlement(FxCashSettlement nonDeliverableSettlement) {
			this.nonDeliverableSettlement = nonDeliverableSettlement==null?null:nonDeliverableSettlement.toBuilder();
			return this;
		}
		@Override
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder addDisruption(FxDisruption disruption) {
			if (disruption!=null) this.disruption.add(disruption.toBuilder());
			return this;
		}
		
		@Override
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder addDisruption(FxDisruption disruption, int _idx) {
			getIndex(this.disruption, _idx, () -> disruption.toBuilder());
			return this;
		}
		@Override 
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder addDisruption(List<? extends FxDisruption> disruptions) {
			if (disruptions != null) {
				for (FxDisruption toAdd : disruptions) {
					this.disruption.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("disruption")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder setDisruption(List<? extends FxDisruption> disruptions) {
			if (disruptions == null)  {
				this.disruption = new ArrayList<>();
			}
			else {
				this.disruption = disruptions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxCoreDetailsModel build() {
			return new FxCoreDetailsModel.FxCoreDetailsModelImpl(this);
		}
		
		@Override
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder prune() {
			if (exchangedCurrency1!=null && !exchangedCurrency1.prune().hasData()) exchangedCurrency1 = null;
			if (exchangedCurrency2!=null && !exchangedCurrency2.prune().hasData()) exchangedCurrency2 = null;
			if (fxTenorModel!=null && !fxTenorModel.prune().hasData()) fxTenorModel = null;
			if (fxCoreDetailsModelSequence!=null && !fxCoreDetailsModelSequence.prune().hasData()) fxCoreDetailsModelSequence = null;
			if (exchangeRate!=null && !exchangeRate.prune().hasData()) exchangeRate = null;
			if (nonDeliverableSettlement!=null && !nonDeliverableSettlement.prune().hasData()) nonDeliverableSettlement = null;
			disruption = disruption.stream().filter(b->b!=null).<FxDisruption.FxDisruptionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExchangedCurrency1()!=null && getExchangedCurrency1().hasData()) return true;
			if (getExchangedCurrency2()!=null && getExchangedCurrency2().hasData()) return true;
			if (getDealtCurrency()!=null) return true;
			if (getFxTenorModel()!=null && getFxTenorModel().hasData()) return true;
			if (getValueDate()!=null) return true;
			if (getFxCoreDetailsModelSequence()!=null && getFxCoreDetailsModelSequence().hasData()) return true;
			if (getExchangeRate()!=null && getExchangeRate().hasData()) return true;
			if (getNonDeliverableSettlement()!=null && getNonDeliverableSettlement().hasData()) return true;
			if (getDisruption()!=null && getDisruption().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxCoreDetailsModel.FxCoreDetailsModelBuilder o = (FxCoreDetailsModel.FxCoreDetailsModelBuilder) other;
			
			merger.mergeRosetta(getExchangedCurrency1(), o.getExchangedCurrency1(), this::setExchangedCurrency1);
			merger.mergeRosetta(getExchangedCurrency2(), o.getExchangedCurrency2(), this::setExchangedCurrency2);
			merger.mergeRosetta(getFxTenorModel(), o.getFxTenorModel(), this::setFxTenorModel);
			merger.mergeRosetta(getFxCoreDetailsModelSequence(), o.getFxCoreDetailsModelSequence(), this::setFxCoreDetailsModelSequence);
			merger.mergeRosetta(getExchangeRate(), o.getExchangeRate(), this::setExchangeRate);
			merger.mergeRosetta(getNonDeliverableSettlement(), o.getNonDeliverableSettlement(), this::setNonDeliverableSettlement);
			merger.mergeRosetta(getDisruption(), o.getDisruption(), this::getOrCreateDisruption);
			
			merger.mergeBasic(getDealtCurrency(), o.getDealtCurrency(), this::setDealtCurrency);
			merger.mergeBasic(getValueDate(), o.getValueDate(), this::setValueDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCoreDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			if (!Objects.equals(dealtCurrency, _that.getDealtCurrency())) return false;
			if (!Objects.equals(fxTenorModel, _that.getFxTenorModel())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!Objects.equals(fxCoreDetailsModelSequence, _that.getFxCoreDetailsModelSequence())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(nonDeliverableSettlement, _that.getNonDeliverableSettlement())) return false;
			if (!ListEquals.listEquals(disruption, _that.getDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			_result = 31 * _result + (dealtCurrency != null ? dealtCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxTenorModel != null ? fxTenorModel.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (fxCoreDetailsModelSequence != null ? fxCoreDetailsModelSequence.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSettlement != null ? nonDeliverableSettlement.hashCode() : 0);
			_result = 31 * _result + (disruption != null ? disruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCoreDetailsModelBuilder {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 + ", " +
				"dealtCurrency=" + this.dealtCurrency + ", " +
				"fxTenorModel=" + this.fxTenorModel + ", " +
				"valueDate=" + this.valueDate + ", " +
				"fxCoreDetailsModelSequence=" + this.fxCoreDetailsModelSequence + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"nonDeliverableSettlement=" + this.nonDeliverableSettlement + ", " +
				"disruption=" + this.disruption +
			'}';
		}
	}
}
