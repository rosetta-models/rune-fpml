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
import fpml.confirmation.AssetMeasureType;
import fpml.confirmation.CashflowType;
import fpml.confirmation.Currency;
import fpml.confirmation.InformationSource;
import fpml.confirmation.PriceQuoteUnits;
import fpml.confirmation.PricingModel;
import fpml.confirmation.QuotationCharacteristicsModel;
import fpml.confirmation.QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder;
import fpml.confirmation.QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilderImpl;
import fpml.confirmation.QuotationCharacteristicsModel.QuotationCharacteristicsModelImpl;
import fpml.confirmation.QuotationSideEnum;
import fpml.confirmation.QuoteLocationModel;
import fpml.confirmation.QuoteTiming;
import fpml.confirmation.ReportingCurrencyType;
import fpml.confirmation.meta.QuotationCharacteristicsModelMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A group collecting a set of characteristics that can be used to describe a quotation.
 * @version ${project.version}
 */
@RosettaDataType(value="QuotationCharacteristicsModel", builder=QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilderImpl.class, version="${project.version}")
public interface QuotationCharacteristicsModel extends RosettaModelObject {

	QuotationCharacteristicsModelMeta metaData = new QuotationCharacteristicsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of the value that is measured. This could be an NPV, a cash flow, a clean price, etc.
	 */
	AssetMeasureType getMeasureType();
	/**
	 * The optional units that the measure is expressed in. If not supplied, this is assumed to be a price/value in currency units.
	 */
	PriceQuoteUnits getQuoteUnits();
	/**
	 * The side (bid/mid/ask) of the measure.
	 */
	QuotationSideEnum getSide();
	/**
	 * The optional currency that the measure is expressed in. If not supplied, this is defaulted from the reportingCurrency in the valuationScenarioDefinition.
	 */
	Currency getCurrency();
	/**
	 * The optional currency that the measure is expressed in. If not supplied, this is defaulted from the reportingCurrency in the valuationScenarioDefinition.
	 */
	ReportingCurrencyType getCurrencyType();
	/**
	 * When during a day the quote is for. Typically, if this element is supplied, the QuoteLocation needs also to be supplied.
	 */
	QuoteTiming getTiming();
	QuoteLocationModel getQuoteLocationModel();
	/**
	 * The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 */
	List<? extends InformationSource> getInformationSource();
	/**
	 * .
	 */
	PricingModel getPricingModel();
	/**
	 * When the quote was observed or when a calculated value was generated.
	 */
	ZonedDateTime getTime();
	/**
	 * When the quote was computed.
	 */
	Date getValuationDate();
	/**
	 * When does the quote cease to be valid.
	 */
	ZonedDateTime getExpiryTime();
	/**
	 * For cash flows, the type of the cash flows. Examples include: Coupon payment, Premium Fee, Settlement Fee, Brokerage Fee, etc.
	 */
	CashflowType getCashflowType();

	/*********************** Build Methods  ***********************/
	QuotationCharacteristicsModel build();
	
	QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder toBuilder();
	
	static QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder builder() {
		return new QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuotationCharacteristicsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends QuotationCharacteristicsModel> getType() {
		return QuotationCharacteristicsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("measureType"), processor, AssetMeasureType.class, getMeasureType());
		processRosetta(path.newSubPath("quoteUnits"), processor, PriceQuoteUnits.class, getQuoteUnits());
		processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("currencyType"), processor, ReportingCurrencyType.class, getCurrencyType());
		processRosetta(path.newSubPath("timing"), processor, QuoteTiming.class, getTiming());
		processRosetta(path.newSubPath("quoteLocationModel"), processor, QuoteLocationModel.class, getQuoteLocationModel());
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("pricingModel"), processor, PricingModel.class, getPricingModel());
		processor.processBasic(path.newSubPath("time"), ZonedDateTime.class, getTime(), this);
		processor.processBasic(path.newSubPath("valuationDate"), Date.class, getValuationDate(), this);
		processor.processBasic(path.newSubPath("expiryTime"), ZonedDateTime.class, getExpiryTime(), this);
		processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.class, getCashflowType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuotationCharacteristicsModelBuilder extends QuotationCharacteristicsModel, RosettaModelObjectBuilder {
		AssetMeasureType.AssetMeasureTypeBuilder getOrCreateMeasureType();
		AssetMeasureType.AssetMeasureTypeBuilder getMeasureType();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateQuoteUnits();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getQuoteUnits();
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		ReportingCurrencyType.ReportingCurrencyTypeBuilder getOrCreateCurrencyType();
		ReportingCurrencyType.ReportingCurrencyTypeBuilder getCurrencyType();
		QuoteTiming.QuoteTimingBuilder getOrCreateTiming();
		QuoteTiming.QuoteTimingBuilder getTiming();
		QuoteLocationModel.QuoteLocationModelBuilder getOrCreateQuoteLocationModel();
		QuoteLocationModel.QuoteLocationModelBuilder getQuoteLocationModel();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource(int _index);
		List<? extends InformationSource.InformationSourceBuilder> getInformationSource();
		PricingModel.PricingModelBuilder getOrCreatePricingModel();
		PricingModel.PricingModelBuilder getPricingModel();
		CashflowType.CashflowTypeBuilder getOrCreateCashflowType();
		CashflowType.CashflowTypeBuilder getCashflowType();
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setMeasureType(AssetMeasureType measureType);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setQuoteUnits(PriceQuoteUnits quoteUnits);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setSide(QuotationSideEnum side);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setCurrency(Currency currency);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setCurrencyType(ReportingCurrencyType currencyType);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setTiming(QuoteTiming timing);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setQuoteLocationModel(QuoteLocationModel quoteLocationModel);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder addInformationSource(InformationSource informationSource0);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder addInformationSource(InformationSource informationSource1, int _idx);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder addInformationSource(List<? extends InformationSource> informationSource2);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setInformationSource(List<? extends InformationSource> informationSource3);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setPricingModel(PricingModel pricingModel);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setTime(ZonedDateTime time);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setValuationDate(Date valuationDate);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setExpiryTime(ZonedDateTime expiryTime);
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setCashflowType(CashflowType cashflowType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("measureType"), processor, AssetMeasureType.AssetMeasureTypeBuilder.class, getMeasureType());
			processRosetta(path.newSubPath("quoteUnits"), processor, PriceQuoteUnits.PriceQuoteUnitsBuilder.class, getQuoteUnits());
			processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("currencyType"), processor, ReportingCurrencyType.ReportingCurrencyTypeBuilder.class, getCurrencyType());
			processRosetta(path.newSubPath("timing"), processor, QuoteTiming.QuoteTimingBuilder.class, getTiming());
			processRosetta(path.newSubPath("quoteLocationModel"), processor, QuoteLocationModel.QuoteLocationModelBuilder.class, getQuoteLocationModel());
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("pricingModel"), processor, PricingModel.PricingModelBuilder.class, getPricingModel());
			processor.processBasic(path.newSubPath("time"), ZonedDateTime.class, getTime(), this);
			processor.processBasic(path.newSubPath("valuationDate"), Date.class, getValuationDate(), this);
			processor.processBasic(path.newSubPath("expiryTime"), ZonedDateTime.class, getExpiryTime(), this);
			processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.CashflowTypeBuilder.class, getCashflowType());
		}
		

		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder prune();
	}

	/*********************** Immutable Implementation of QuotationCharacteristicsModel  ***********************/
	class QuotationCharacteristicsModelImpl implements QuotationCharacteristicsModel {
		private final AssetMeasureType measureType;
		private final PriceQuoteUnits quoteUnits;
		private final QuotationSideEnum side;
		private final Currency currency;
		private final ReportingCurrencyType currencyType;
		private final QuoteTiming timing;
		private final QuoteLocationModel quoteLocationModel;
		private final List<? extends InformationSource> informationSource;
		private final PricingModel pricingModel;
		private final ZonedDateTime time;
		private final Date valuationDate;
		private final ZonedDateTime expiryTime;
		private final CashflowType cashflowType;
		
		protected QuotationCharacteristicsModelImpl(QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder builder) {
			this.measureType = ofNullable(builder.getMeasureType()).map(f->f.build()).orElse(null);
			this.quoteUnits = ofNullable(builder.getQuoteUnits()).map(f->f.build()).orElse(null);
			this.side = builder.getSide();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.currencyType = ofNullable(builder.getCurrencyType()).map(f->f.build()).orElse(null);
			this.timing = ofNullable(builder.getTiming()).map(f->f.build()).orElse(null);
			this.quoteLocationModel = ofNullable(builder.getQuoteLocationModel()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.pricingModel = ofNullable(builder.getPricingModel()).map(f->f.build()).orElse(null);
			this.time = builder.getTime();
			this.valuationDate = builder.getValuationDate();
			this.expiryTime = builder.getExpiryTime();
			this.cashflowType = ofNullable(builder.getCashflowType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("measureType")
		public AssetMeasureType getMeasureType() {
			return measureType;
		}
		
		@Override
		@RosettaAttribute("quoteUnits")
		public PriceQuoteUnits getQuoteUnits() {
			return quoteUnits;
		}
		
		@Override
		@RosettaAttribute("side")
		public QuotationSideEnum getSide() {
			return side;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("currencyType")
		public ReportingCurrencyType getCurrencyType() {
			return currencyType;
		}
		
		@Override
		@RosettaAttribute("timing")
		public QuoteTiming getTiming() {
			return timing;
		}
		
		@Override
		@RosettaAttribute("quoteLocationModel")
		public QuoteLocationModel getQuoteLocationModel() {
			return quoteLocationModel;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public List<? extends InformationSource> getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("pricingModel")
		public PricingModel getPricingModel() {
			return pricingModel;
		}
		
		@Override
		@RosettaAttribute("time")
		public ZonedDateTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public Date getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		public ZonedDateTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		public CashflowType getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public QuotationCharacteristicsModel build() {
			return this;
		}
		
		@Override
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder toBuilder() {
			QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder builder) {
			ofNullable(getMeasureType()).ifPresent(builder::setMeasureType);
			ofNullable(getQuoteUnits()).ifPresent(builder::setQuoteUnits);
			ofNullable(getSide()).ifPresent(builder::setSide);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getCurrencyType()).ifPresent(builder::setCurrencyType);
			ofNullable(getTiming()).ifPresent(builder::setTiming);
			ofNullable(getQuoteLocationModel()).ifPresent(builder::setQuoteLocationModel);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getPricingModel()).ifPresent(builder::setPricingModel);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
			ofNullable(getCashflowType()).ifPresent(builder::setCashflowType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotationCharacteristicsModel _that = getType().cast(o);
		
			if (!Objects.equals(measureType, _that.getMeasureType())) return false;
			if (!Objects.equals(quoteUnits, _that.getQuoteUnits())) return false;
			if (!Objects.equals(side, _that.getSide())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(currencyType, _that.getCurrencyType())) return false;
			if (!Objects.equals(timing, _that.getTiming())) return false;
			if (!Objects.equals(quoteLocationModel, _that.getQuoteLocationModel())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(pricingModel, _that.getPricingModel())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (measureType != null ? measureType.hashCode() : 0);
			_result = 31 * _result + (quoteUnits != null ? quoteUnits.hashCode() : 0);
			_result = 31 * _result + (side != null ? side.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (currencyType != null ? currencyType.hashCode() : 0);
			_result = 31 * _result + (timing != null ? timing.hashCode() : 0);
			_result = 31 * _result + (quoteLocationModel != null ? quoteLocationModel.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (pricingModel != null ? pricingModel.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotationCharacteristicsModel {" +
				"measureType=" + this.measureType + ", " +
				"quoteUnits=" + this.quoteUnits + ", " +
				"side=" + this.side + ", " +
				"currency=" + this.currency + ", " +
				"currencyType=" + this.currencyType + ", " +
				"timing=" + this.timing + ", " +
				"quoteLocationModel=" + this.quoteLocationModel + ", " +
				"informationSource=" + this.informationSource + ", " +
				"pricingModel=" + this.pricingModel + ", " +
				"time=" + this.time + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cashflowType=" + this.cashflowType +
			'}';
		}
	}

	/*********************** Builder Implementation of QuotationCharacteristicsModel  ***********************/
	class QuotationCharacteristicsModelBuilderImpl implements QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder {
	
		protected AssetMeasureType.AssetMeasureTypeBuilder measureType;
		protected PriceQuoteUnits.PriceQuoteUnitsBuilder quoteUnits;
		protected QuotationSideEnum side;
		protected Currency.CurrencyBuilder currency;
		protected ReportingCurrencyType.ReportingCurrencyTypeBuilder currencyType;
		protected QuoteTiming.QuoteTimingBuilder timing;
		protected QuoteLocationModel.QuoteLocationModelBuilder quoteLocationModel;
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		protected PricingModel.PricingModelBuilder pricingModel;
		protected ZonedDateTime time;
		protected Date valuationDate;
		protected ZonedDateTime expiryTime;
		protected CashflowType.CashflowTypeBuilder cashflowType;
	
		public QuotationCharacteristicsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("measureType")
		public AssetMeasureType.AssetMeasureTypeBuilder getMeasureType() {
			return measureType;
		}
		
		@Override
		public AssetMeasureType.AssetMeasureTypeBuilder getOrCreateMeasureType() {
			AssetMeasureType.AssetMeasureTypeBuilder result;
			if (measureType!=null) {
				result = measureType;
			}
			else {
				result = measureType = AssetMeasureType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quoteUnits")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getQuoteUnits() {
			return quoteUnits;
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateQuoteUnits() {
			PriceQuoteUnits.PriceQuoteUnitsBuilder result;
			if (quoteUnits!=null) {
				result = quoteUnits;
			}
			else {
				result = quoteUnits = PriceQuoteUnits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("side")
		public QuotationSideEnum getSide() {
			return side;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currencyType")
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder getCurrencyType() {
			return currencyType;
		}
		
		@Override
		public ReportingCurrencyType.ReportingCurrencyTypeBuilder getOrCreateCurrencyType() {
			ReportingCurrencyType.ReportingCurrencyTypeBuilder result;
			if (currencyType!=null) {
				result = currencyType;
			}
			else {
				result = currencyType = ReportingCurrencyType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("timing")
		public QuoteTiming.QuoteTimingBuilder getTiming() {
			return timing;
		}
		
		@Override
		public QuoteTiming.QuoteTimingBuilder getOrCreateTiming() {
			QuoteTiming.QuoteTimingBuilder result;
			if (timing!=null) {
				result = timing;
			}
			else {
				result = timing = QuoteTiming.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quoteLocationModel")
		public QuoteLocationModel.QuoteLocationModelBuilder getQuoteLocationModel() {
			return quoteLocationModel;
		}
		
		@Override
		public QuoteLocationModel.QuoteLocationModelBuilder getOrCreateQuoteLocationModel() {
			QuoteLocationModel.QuoteLocationModelBuilder result;
			if (quoteLocationModel!=null) {
				result = quoteLocationModel;
			}
			else {
				result = quoteLocationModel = QuoteLocationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public List<? extends InformationSource.InformationSourceBuilder> getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource(int _index) {
		
			if (informationSource==null) {
				this.informationSource = new ArrayList<>();
			}
			InformationSource.InformationSourceBuilder result;
			return getIndex(informationSource, _index, () -> {
						InformationSource.InformationSourceBuilder newInformationSource = InformationSource.builder();
						return newInformationSource;
					});
		}
		
		@Override
		@RosettaAttribute("pricingModel")
		public PricingModel.PricingModelBuilder getPricingModel() {
			return pricingModel;
		}
		
		@Override
		public PricingModel.PricingModelBuilder getOrCreatePricingModel() {
			PricingModel.PricingModelBuilder result;
			if (pricingModel!=null) {
				result = pricingModel;
			}
			else {
				result = pricingModel = PricingModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("time")
		public ZonedDateTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		public Date getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		public ZonedDateTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		public CashflowType.CashflowTypeBuilder getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public CashflowType.CashflowTypeBuilder getOrCreateCashflowType() {
			CashflowType.CashflowTypeBuilder result;
			if (cashflowType!=null) {
				result = cashflowType;
			}
			else {
				result = cashflowType = CashflowType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("measureType")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setMeasureType(AssetMeasureType measureType) {
			this.measureType = measureType==null?null:measureType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quoteUnits")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setQuoteUnits(PriceQuoteUnits quoteUnits) {
			this.quoteUnits = quoteUnits==null?null:quoteUnits.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("side")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setSide(QuotationSideEnum side) {
			this.side = side==null?null:side;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currencyType")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setCurrencyType(ReportingCurrencyType currencyType) {
			this.currencyType = currencyType==null?null:currencyType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("timing")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setTiming(QuoteTiming timing) {
			this.timing = timing==null?null:timing.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quoteLocationModel")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setQuoteLocationModel(QuoteLocationModel quoteLocationModel) {
			this.quoteLocationModel = quoteLocationModel==null?null:quoteLocationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder addInformationSource(InformationSource informationSource) {
			if (informationSource!=null) this.informationSource.add(informationSource.toBuilder());
			return this;
		}
		
		@Override
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder addInformationSource(InformationSource informationSource, int _idx) {
			getIndex(this.informationSource, _idx, () -> informationSource.toBuilder());
			return this;
		}
		@Override 
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder addInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources != null) {
				for (InformationSource toAdd : informationSources) {
					this.informationSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources == null)  {
				this.informationSource = new ArrayList<>();
			}
			else {
				this.informationSource = informationSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("pricingModel")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setPricingModel(PricingModel pricingModel) {
			this.pricingModel = pricingModel==null?null:pricingModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("time")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setTime(ZonedDateTime time) {
			this.time = time==null?null:time;
			return this;
		}
		@Override
		@RosettaAttribute("valuationDate")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setValuationDate(Date valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate;
			return this;
		}
		@Override
		@RosettaAttribute("expiryTime")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setExpiryTime(ZonedDateTime expiryTime) {
			this.expiryTime = expiryTime==null?null:expiryTime;
			return this;
		}
		@Override
		@RosettaAttribute("cashflowType")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder setCashflowType(CashflowType cashflowType) {
			this.cashflowType = cashflowType==null?null:cashflowType.toBuilder();
			return this;
		}
		
		@Override
		public QuotationCharacteristicsModel build() {
			return new QuotationCharacteristicsModel.QuotationCharacteristicsModelImpl(this);
		}
		
		@Override
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder prune() {
			if (measureType!=null && !measureType.prune().hasData()) measureType = null;
			if (quoteUnits!=null && !quoteUnits.prune().hasData()) quoteUnits = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (currencyType!=null && !currencyType.prune().hasData()) currencyType = null;
			if (timing!=null && !timing.prune().hasData()) timing = null;
			if (quoteLocationModel!=null && !quoteLocationModel.prune().hasData()) quoteLocationModel = null;
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (pricingModel!=null && !pricingModel.prune().hasData()) pricingModel = null;
			if (cashflowType!=null && !cashflowType.prune().hasData()) cashflowType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMeasureType()!=null && getMeasureType().hasData()) return true;
			if (getQuoteUnits()!=null && getQuoteUnits().hasData()) return true;
			if (getSide()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getCurrencyType()!=null && getCurrencyType().hasData()) return true;
			if (getTiming()!=null && getTiming().hasData()) return true;
			if (getQuoteLocationModel()!=null && getQuoteLocationModel().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPricingModel()!=null && getPricingModel().hasData()) return true;
			if (getTime()!=null) return true;
			if (getValuationDate()!=null) return true;
			if (getExpiryTime()!=null) return true;
			if (getCashflowType()!=null && getCashflowType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder o = (QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder) other;
			
			merger.mergeRosetta(getMeasureType(), o.getMeasureType(), this::setMeasureType);
			merger.mergeRosetta(getQuoteUnits(), o.getQuoteUnits(), this::setQuoteUnits);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getCurrencyType(), o.getCurrencyType(), this::setCurrencyType);
			merger.mergeRosetta(getTiming(), o.getTiming(), this::setTiming);
			merger.mergeRosetta(getQuoteLocationModel(), o.getQuoteLocationModel(), this::setQuoteLocationModel);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			merger.mergeRosetta(getPricingModel(), o.getPricingModel(), this::setPricingModel);
			merger.mergeRosetta(getCashflowType(), o.getCashflowType(), this::setCashflowType);
			
			merger.mergeBasic(getSide(), o.getSide(), this::setSide);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			merger.mergeBasic(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeBasic(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotationCharacteristicsModel _that = getType().cast(o);
		
			if (!Objects.equals(measureType, _that.getMeasureType())) return false;
			if (!Objects.equals(quoteUnits, _that.getQuoteUnits())) return false;
			if (!Objects.equals(side, _that.getSide())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(currencyType, _that.getCurrencyType())) return false;
			if (!Objects.equals(timing, _that.getTiming())) return false;
			if (!Objects.equals(quoteLocationModel, _that.getQuoteLocationModel())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(pricingModel, _that.getPricingModel())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (measureType != null ? measureType.hashCode() : 0);
			_result = 31 * _result + (quoteUnits != null ? quoteUnits.hashCode() : 0);
			_result = 31 * _result + (side != null ? side.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (currencyType != null ? currencyType.hashCode() : 0);
			_result = 31 * _result + (timing != null ? timing.hashCode() : 0);
			_result = 31 * _result + (quoteLocationModel != null ? quoteLocationModel.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (pricingModel != null ? pricingModel.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotationCharacteristicsModelBuilder {" +
				"measureType=" + this.measureType + ", " +
				"quoteUnits=" + this.quoteUnits + ", " +
				"side=" + this.side + ", " +
				"currency=" + this.currency + ", " +
				"currencyType=" + this.currencyType + ", " +
				"timing=" + this.timing + ", " +
				"quoteLocationModel=" + this.quoteLocationModel + ", " +
				"informationSource=" + this.informationSource + ", " +
				"pricingModel=" + this.pricingModel + ", " +
				"time=" + this.time + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cashflowType=" + this.cashflowType +
			'}';
		}
	}
}
