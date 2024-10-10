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
import fpml.confirmation.Asset;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRate;
import fpml.confirmation.GenericProductExchangeRate;
import fpml.confirmation.IndexReferenceInformation;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.Schedule;
import fpml.confirmation.TradeUnderlyer2;
import fpml.confirmation.TradeUnderlyer2.TradeUnderlyer2Builder;
import fpml.confirmation.TradeUnderlyer2.TradeUnderlyer2BuilderImpl;
import fpml.confirmation.TradeUnderlyer2.TradeUnderlyer2Impl;
import fpml.confirmation.meta.TradeUnderlyer2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The underlying asset/index/reference price etc. whose rate/price may be observed to compute the value of the cashflow. It can be an index, fixed rate, listed security, quoted currency pair, or a reference entity (for credit derivatives). For use with Generic products in Transparency reporting. Generic products define a product that represents an OTC derivative transaction whose economics are not fully described using an FpML schema. In other views, generic products are present for convenience to support internal messaging and workflows that are cross-product. Generic products are not full trade representations as such they are not intended to be used for confirming trades.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeUnderlyer2", builder=TradeUnderlyer2.TradeUnderlyer2BuilderImpl.class, version="${project.version}")
public interface TradeUnderlyer2 extends RosettaModelObject {

	TradeUnderlyer2Meta metaData = new TradeUnderlyer2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A floating rate.
	 */
	FloatingRate getFloatingRate();
	/**
	 * The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	Schedule getFixedRate();
	/**
	 * The rate of exchange between two currencies.
	 */
	GenericProductExchangeRate getExchangeRate();
	Asset getUnderlyingAsset();
	/**
	 * Describes the composition of a rate that has been quoted. This includes the two currencies and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * The corporate or sovereign entity on which you are buying or selling protection and any successor that assumes all or substantially all of its contractual and other obligations. It is vital to use the correct legal name of the entity and to be careful not to choose a subsidiary if you really want to trade protection on a parent company. Please note, Reference Entities cannot be senior or subordinated. It is the obligations of the Reference Entities that can be senior or subordinated. ISDA 2003 Term: Reference Entity
	 */
	LegalEntity getReferenceEntity();
	/**
	 * This element contains all the terms relevant to defining the Credit DefaultSwap Index.
	 */
	IndexReferenceInformation getIndexReferenceInformation();
	/**
	 * The parties may specify a Method of Averaging where more than one pricing Dates is being specified as being applicable. This defines the averaging method applicable to this asset (used for Commodities).
	 */
	AveragingMethodEnum getAveragingMethod();
	PayerReceiverModel getPayerReceiverModel();
	BuyerSellerModel getBuyerSellerModel();
	/**
	 * Specifies a day count fraction or fractions that apply to this underlyer; this is provided to meet regulatory reporting requirements, but is not sufficient to to fully represent the economics of the trade..
	 */
	DayCountFraction getDayCountFraction();
	String getId();

	/*********************** Build Methods  ***********************/
	TradeUnderlyer2 build();
	
	TradeUnderlyer2.TradeUnderlyer2Builder toBuilder();
	
	static TradeUnderlyer2.TradeUnderlyer2Builder builder() {
		return new TradeUnderlyer2.TradeUnderlyer2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeUnderlyer2> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeUnderlyer2> getType() {
		return TradeUnderlyer2.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRate"), processor, FloatingRate.class, getFloatingRate());
		processRosetta(path.newSubPath("fixedRate"), processor, Schedule.class, getFixedRate());
		processRosetta(path.newSubPath("exchangeRate"), processor, GenericProductExchangeRate.class, getExchangeRate());
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.class, getReferenceEntity());
		processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.class, getIndexReferenceInformation());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeUnderlyer2Builder extends TradeUnderlyer2, RosettaModelObjectBuilder {
		FloatingRate.FloatingRateBuilder getOrCreateFloatingRate();
		FloatingRate.FloatingRateBuilder getFloatingRate();
		Schedule.ScheduleBuilder getOrCreateFixedRate();
		Schedule.ScheduleBuilder getFixedRate();
		GenericProductExchangeRate.GenericProductExchangeRateBuilder getOrCreateExchangeRate();
		GenericProductExchangeRate.GenericProductExchangeRateBuilder getExchangeRate();
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		Asset.AssetBuilder getUnderlyingAsset();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity();
		LegalEntity.LegalEntityBuilder getReferenceEntity();
		IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation();
		IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation();
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		TradeUnderlyer2.TradeUnderlyer2Builder setFloatingRate(FloatingRate floatingRate);
		TradeUnderlyer2.TradeUnderlyer2Builder setFixedRate(Schedule fixedRate);
		TradeUnderlyer2.TradeUnderlyer2Builder setExchangeRate(GenericProductExchangeRate exchangeRate);
		TradeUnderlyer2.TradeUnderlyer2Builder setUnderlyingAsset(Asset underlyingAsset);
		TradeUnderlyer2.TradeUnderlyer2Builder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		TradeUnderlyer2.TradeUnderlyer2Builder setReferenceEntity(LegalEntity referenceEntity);
		TradeUnderlyer2.TradeUnderlyer2Builder setIndexReferenceInformation(IndexReferenceInformation indexReferenceInformation);
		TradeUnderlyer2.TradeUnderlyer2Builder setAveragingMethod(AveragingMethodEnum averagingMethod);
		TradeUnderlyer2.TradeUnderlyer2Builder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		TradeUnderlyer2.TradeUnderlyer2Builder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		TradeUnderlyer2.TradeUnderlyer2Builder setDayCountFraction(DayCountFraction dayCountFraction);
		TradeUnderlyer2.TradeUnderlyer2Builder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRate"), processor, FloatingRate.FloatingRateBuilder.class, getFloatingRate());
			processRosetta(path.newSubPath("fixedRate"), processor, Schedule.ScheduleBuilder.class, getFixedRate());
			processRosetta(path.newSubPath("exchangeRate"), processor, GenericProductExchangeRate.GenericProductExchangeRateBuilder.class, getExchangeRate());
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getReferenceEntity());
			processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.IndexReferenceInformationBuilder.class, getIndexReferenceInformation());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		TradeUnderlyer2.TradeUnderlyer2Builder prune();
	}

	/*********************** Immutable Implementation of TradeUnderlyer2  ***********************/
	class TradeUnderlyer2Impl implements TradeUnderlyer2 {
		private final FloatingRate floatingRate;
		private final Schedule fixedRate;
		private final GenericProductExchangeRate exchangeRate;
		private final Asset underlyingAsset;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final LegalEntity referenceEntity;
		private final IndexReferenceInformation indexReferenceInformation;
		private final AveragingMethodEnum averagingMethod;
		private final PayerReceiverModel payerReceiverModel;
		private final BuyerSellerModel buyerSellerModel;
		private final DayCountFraction dayCountFraction;
		private final String id;
		
		protected TradeUnderlyer2Impl(TradeUnderlyer2.TradeUnderlyer2Builder builder) {
			this.floatingRate = ofNullable(builder.getFloatingRate()).map(f->f.build()).orElse(null);
			this.fixedRate = ofNullable(builder.getFixedRate()).map(f->f.build()).orElse(null);
			this.exchangeRate = ofNullable(builder.getExchangeRate()).map(f->f.build()).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.referenceEntity = ofNullable(builder.getReferenceEntity()).map(f->f.build()).orElse(null);
			this.indexReferenceInformation = ofNullable(builder.getIndexReferenceInformation()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		public FloatingRate getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public Schedule getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		public GenericProductExchangeRate getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		public LegalEntity getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		public IndexReferenceInformation getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public TradeUnderlyer2 build() {
			return this;
		}
		
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder toBuilder() {
			TradeUnderlyer2.TradeUnderlyer2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeUnderlyer2.TradeUnderlyer2Builder builder) {
			ofNullable(getFloatingRate()).ifPresent(builder::setFloatingRate);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getExchangeRate()).ifPresent(builder::setExchangeRate);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getReferenceEntity()).ifPresent(builder::setReferenceEntity);
			ofNullable(getIndexReferenceInformation()).ifPresent(builder::setIndexReferenceInformation);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeUnderlyer2 _that = getType().cast(o);
		
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeUnderlyer2 {" +
				"floatingRate=" + this.floatingRate + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeUnderlyer2  ***********************/
	class TradeUnderlyer2BuilderImpl implements TradeUnderlyer2.TradeUnderlyer2Builder {
	
		protected FloatingRate.FloatingRateBuilder floatingRate;
		protected Schedule.ScheduleBuilder fixedRate;
		protected GenericProductExchangeRate.GenericProductExchangeRateBuilder exchangeRate;
		protected Asset.AssetBuilder underlyingAsset;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected LegalEntity.LegalEntityBuilder referenceEntity;
		protected IndexReferenceInformation.IndexReferenceInformationBuilder indexReferenceInformation;
		protected AveragingMethodEnum averagingMethod;
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected String id;
	
		public TradeUnderlyer2BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRate")
		public FloatingRate.FloatingRateBuilder getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder getOrCreateFloatingRate() {
			FloatingRate.FloatingRateBuilder result;
			if (floatingRate!=null) {
				result = floatingRate;
			}
			else {
				result = floatingRate = FloatingRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public Schedule.ScheduleBuilder getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFixedRate() {
			Schedule.ScheduleBuilder result;
			if (fixedRate!=null) {
				result = fixedRate;
			}
			else {
				result = fixedRate = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		public GenericProductExchangeRate.GenericProductExchangeRateBuilder getOrCreateExchangeRate() {
			GenericProductExchangeRate.GenericProductExchangeRateBuilder result;
			if (exchangeRate!=null) {
				result = exchangeRate;
			}
			else {
				result = exchangeRate = GenericProductExchangeRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		public LegalEntity.LegalEntityBuilder getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (referenceEntity!=null) {
				result = referenceEntity;
			}
			else {
				result = referenceEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		public IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation() {
			IndexReferenceInformation.IndexReferenceInformationBuilder result;
			if (indexReferenceInformation!=null) {
				result = indexReferenceInformation;
			}
			else {
				result = indexReferenceInformation = IndexReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		public TradeUnderlyer2.TradeUnderlyer2Builder setFloatingRate(FloatingRate floatingRate) {
			this.floatingRate = floatingRate==null?null:floatingRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRate")
		public TradeUnderlyer2.TradeUnderlyer2Builder setFixedRate(Schedule fixedRate) {
			this.fixedRate = fixedRate==null?null:fixedRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeRate")
		public TradeUnderlyer2.TradeUnderlyer2Builder setExchangeRate(GenericProductExchangeRate exchangeRate) {
			this.exchangeRate = exchangeRate==null?null:exchangeRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyingAsset")
		public TradeUnderlyer2.TradeUnderlyer2Builder setUnderlyingAsset(Asset underlyingAsset) {
			this.underlyingAsset = underlyingAsset==null?null:underlyingAsset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public TradeUnderlyer2.TradeUnderlyer2Builder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceEntity")
		public TradeUnderlyer2.TradeUnderlyer2Builder setReferenceEntity(LegalEntity referenceEntity) {
			this.referenceEntity = referenceEntity==null?null:referenceEntity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexReferenceInformation")
		public TradeUnderlyer2.TradeUnderlyer2Builder setIndexReferenceInformation(IndexReferenceInformation indexReferenceInformation) {
			this.indexReferenceInformation = indexReferenceInformation==null?null:indexReferenceInformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public TradeUnderlyer2.TradeUnderlyer2Builder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public TradeUnderlyer2.TradeUnderlyer2Builder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public TradeUnderlyer2.TradeUnderlyer2Builder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public TradeUnderlyer2.TradeUnderlyer2Builder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public TradeUnderlyer2.TradeUnderlyer2Builder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public TradeUnderlyer2 build() {
			return new TradeUnderlyer2.TradeUnderlyer2Impl(this);
		}
		
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder prune() {
			if (floatingRate!=null && !floatingRate.prune().hasData()) floatingRate = null;
			if (fixedRate!=null && !fixedRate.prune().hasData()) fixedRate = null;
			if (exchangeRate!=null && !exchangeRate.prune().hasData()) exchangeRate = null;
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (referenceEntity!=null && !referenceEntity.prune().hasData()) referenceEntity = null;
			if (indexReferenceInformation!=null && !indexReferenceInformation.prune().hasData()) indexReferenceInformation = null;
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRate()!=null && getFloatingRate().hasData()) return true;
			if (getFixedRate()!=null && getFixedRate().hasData()) return true;
			if (getExchangeRate()!=null && getExchangeRate().hasData()) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getReferenceEntity()!=null && getReferenceEntity().hasData()) return true;
			if (getIndexReferenceInformation()!=null && getIndexReferenceInformation().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeUnderlyer2.TradeUnderlyer2Builder o = (TradeUnderlyer2.TradeUnderlyer2Builder) other;
			
			merger.mergeRosetta(getFloatingRate(), o.getFloatingRate(), this::setFloatingRate);
			merger.mergeRosetta(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeRosetta(getExchangeRate(), o.getExchangeRate(), this::setExchangeRate);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeRosetta(getIndexReferenceInformation(), o.getIndexReferenceInformation(), this::setIndexReferenceInformation);
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeUnderlyer2 _that = getType().cast(o);
		
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeUnderlyer2Builder {" +
				"floatingRate=" + this.floatingRate + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
