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
import fpml.confirmation.CalculationPeriod;
import fpml.confirmation.Money;
import fpml.confirmation.PaymentCalculationPeriod;
import fpml.confirmation.PaymentCalculationPeriod.PaymentCalculationPeriodBuilder;
import fpml.confirmation.PaymentCalculationPeriod.PaymentCalculationPeriodBuilderImpl;
import fpml.confirmation.PaymentCalculationPeriod.PaymentCalculationPeriodImpl;
import fpml.confirmation.meta.PaymentCalculationPeriodMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. This type forms part of the cashflow representation of a swap stream.
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentCalculationPeriod", builder=PaymentCalculationPeriod.PaymentCalculationPeriodBuilderImpl.class, version="${project.version}")
public interface PaymentCalculationPeriod extends RosettaModelObject {

	PaymentCalculationPeriodMeta metaData = new PaymentCalculationPeriodMeta();

	/*********************** Getter Methods  ***********************/
	Date getUnadjustedPaymentDate();
	/**
	 * The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component (all dates the Cashflows type are adjusted payment dates).
	 */
	Date getAdjustedPaymentDate();
	/**
	 * The parameters used in the calculation of a fixed or floating rate calculation period amount. A list of calculation period elements may be ordered in the document by ascending start date. An FpML document which contains an unordered list of calcularion periods is still regarded as a conformant document.
	 */
	List<? extends CalculationPeriod> getCalculationPeriod();
	/**
	 * A known fixed payment amount.
	 */
	BigDecimal getFixedPaymentAmount();
	/**
	 * A decimal value representing the discount factor used to calculate the present value of cash flow.
	 */
	BigDecimal getDiscountFactor();
	/**
	 * A monetary amount representing the forecast of the future value of the payment.
	 */
	Money getForecastPaymentAmount();
	/**
	 * A monetary amount representing the present value of the forecast payment.
	 */
	Money getPresentValueAmount();
	String getId();
	/**
	 * Attribute that can be used to reference the yield curve used to estimate the discount factor.
	 */
	String getHref();

	/*********************** Build Methods  ***********************/
	PaymentCalculationPeriod build();
	
	PaymentCalculationPeriod.PaymentCalculationPeriodBuilder toBuilder();
	
	static PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder() {
		return new PaymentCalculationPeriod.PaymentCalculationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentCalculationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentCalculationPeriod> getType() {
		return PaymentCalculationPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedPaymentDate"), Date.class, getUnadjustedPaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
		processRosetta(path.newSubPath("calculationPeriod"), processor, CalculationPeriod.class, getCalculationPeriod());
		processor.processBasic(path.newSubPath("fixedPaymentAmount"), BigDecimal.class, getFixedPaymentAmount(), this);
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processRosetta(path.newSubPath("forecastPaymentAmount"), processor, Money.class, getForecastPaymentAmount());
		processRosetta(path.newSubPath("presentValueAmount"), processor, Money.class, getPresentValueAmount());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentCalculationPeriodBuilder extends PaymentCalculationPeriod, RosettaModelObjectBuilder {
		CalculationPeriod.CalculationPeriodBuilder getOrCreateCalculationPeriod(int _index);
		List<? extends CalculationPeriod.CalculationPeriodBuilder> getCalculationPeriod();
		Money.MoneyBuilder getOrCreateForecastPaymentAmount();
		Money.MoneyBuilder getForecastPaymentAmount();
		Money.MoneyBuilder getOrCreatePresentValueAmount();
		Money.MoneyBuilder getPresentValueAmount();
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setUnadjustedPaymentDate(Date unadjustedPaymentDate);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setAdjustedPaymentDate(Date adjustedPaymentDate);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod0);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod1, int _idx);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(List<? extends CalculationPeriod> calculationPeriod2);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setCalculationPeriod(List<? extends CalculationPeriod> calculationPeriod3);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setFixedPaymentAmount(BigDecimal fixedPaymentAmount);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setDiscountFactor(BigDecimal discountFactor);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setForecastPaymentAmount(Money forecastPaymentAmount);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setPresentValueAmount(Money presentValueAmount);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setId(String id);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedPaymentDate"), Date.class, getUnadjustedPaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
			processRosetta(path.newSubPath("calculationPeriod"), processor, CalculationPeriod.CalculationPeriodBuilder.class, getCalculationPeriod());
			processor.processBasic(path.newSubPath("fixedPaymentAmount"), BigDecimal.class, getFixedPaymentAmount(), this);
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processRosetta(path.newSubPath("forecastPaymentAmount"), processor, Money.MoneyBuilder.class, getForecastPaymentAmount());
			processRosetta(path.newSubPath("presentValueAmount"), processor, Money.MoneyBuilder.class, getPresentValueAmount());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentCalculationPeriod  ***********************/
	class PaymentCalculationPeriodImpl implements PaymentCalculationPeriod {
		private final Date unadjustedPaymentDate;
		private final Date adjustedPaymentDate;
		private final List<? extends CalculationPeriod> calculationPeriod;
		private final BigDecimal fixedPaymentAmount;
		private final BigDecimal discountFactor;
		private final Money forecastPaymentAmount;
		private final Money presentValueAmount;
		private final String id;
		private final String href;
		
		protected PaymentCalculationPeriodImpl(PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder) {
			this.unadjustedPaymentDate = builder.getUnadjustedPaymentDate();
			this.adjustedPaymentDate = builder.getAdjustedPaymentDate();
			this.calculationPeriod = ofNullable(builder.getCalculationPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fixedPaymentAmount = builder.getFixedPaymentAmount();
			this.discountFactor = builder.getDiscountFactor();
			this.forecastPaymentAmount = ofNullable(builder.getForecastPaymentAmount()).map(f->f.build()).orElse(null);
			this.presentValueAmount = ofNullable(builder.getPresentValueAmount()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("unadjustedPaymentDate")
		public Date getUnadjustedPaymentDate() {
			return unadjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		public List<? extends CalculationPeriod> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		@RosettaAttribute("fixedPaymentAmount")
		public BigDecimal getFixedPaymentAmount() {
			return fixedPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("forecastPaymentAmount")
		public Money getForecastPaymentAmount() {
			return forecastPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		public Money getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public PaymentCalculationPeriod build() {
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder toBuilder() {
			PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder) {
			ofNullable(getUnadjustedPaymentDate()).ifPresent(builder::setUnadjustedPaymentDate);
			ofNullable(getAdjustedPaymentDate()).ifPresent(builder::setAdjustedPaymentDate);
			ofNullable(getCalculationPeriod()).ifPresent(builder::setCalculationPeriod);
			ofNullable(getFixedPaymentAmount()).ifPresent(builder::setFixedPaymentAmount);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getForecastPaymentAmount()).ifPresent(builder::setForecastPaymentAmount);
			ofNullable(getPresentValueAmount()).ifPresent(builder::setPresentValueAmount);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedPaymentDate, _that.getUnadjustedPaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(fixedPaymentAmount, _that.getFixedPaymentAmount())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(forecastPaymentAmount, _that.getForecastPaymentAmount())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedPaymentDate != null ? unadjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (fixedPaymentAmount != null ? fixedPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (forecastPaymentAmount != null ? forecastPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentCalculationPeriod {" +
				"unadjustedPaymentDate=" + this.unadjustedPaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"fixedPaymentAmount=" + this.fixedPaymentAmount + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"forecastPaymentAmount=" + this.forecastPaymentAmount + ", " +
				"presentValueAmount=" + this.presentValueAmount + ", " +
				"id=" + this.id + ", " +
				"href=" + this.href +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentCalculationPeriod  ***********************/
	class PaymentCalculationPeriodBuilderImpl implements PaymentCalculationPeriod.PaymentCalculationPeriodBuilder {
	
		protected Date unadjustedPaymentDate;
		protected Date adjustedPaymentDate;
		protected List<CalculationPeriod.CalculationPeriodBuilder> calculationPeriod = new ArrayList<>();
		protected BigDecimal fixedPaymentAmount;
		protected BigDecimal discountFactor;
		protected Money.MoneyBuilder forecastPaymentAmount;
		protected Money.MoneyBuilder presentValueAmount;
		protected String id;
		protected String href;
	
		public PaymentCalculationPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("unadjustedPaymentDate")
		public Date getUnadjustedPaymentDate() {
			return unadjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		public List<? extends CalculationPeriod.CalculationPeriodBuilder> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		public CalculationPeriod.CalculationPeriodBuilder getOrCreateCalculationPeriod(int _index) {
		
			if (calculationPeriod==null) {
				this.calculationPeriod = new ArrayList<>();
			}
			CalculationPeriod.CalculationPeriodBuilder result;
			return getIndex(calculationPeriod, _index, () -> {
						CalculationPeriod.CalculationPeriodBuilder newCalculationPeriod = CalculationPeriod.builder();
						return newCalculationPeriod;
					});
		}
		
		@Override
		@RosettaAttribute("fixedPaymentAmount")
		public BigDecimal getFixedPaymentAmount() {
			return fixedPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("forecastPaymentAmount")
		public Money.MoneyBuilder getForecastPaymentAmount() {
			return forecastPaymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateForecastPaymentAmount() {
			Money.MoneyBuilder result;
			if (forecastPaymentAmount!=null) {
				result = forecastPaymentAmount;
			}
			else {
				result = forecastPaymentAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		public Money.MoneyBuilder getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValueAmount() {
			Money.MoneyBuilder result;
			if (presentValueAmount!=null) {
				result = presentValueAmount;
			}
			else {
				result = presentValueAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("unadjustedPaymentDate")
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setUnadjustedPaymentDate(Date unadjustedPaymentDate) {
			this.unadjustedPaymentDate = unadjustedPaymentDate==null?null:unadjustedPaymentDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setAdjustedPaymentDate(Date adjustedPaymentDate) {
			this.adjustedPaymentDate = adjustedPaymentDate==null?null:adjustedPaymentDate;
			return this;
		}
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod) {
			if (calculationPeriod!=null) this.calculationPeriod.add(calculationPeriod.toBuilder());
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod, int _idx) {
			getIndex(this.calculationPeriod, _idx, () -> calculationPeriod.toBuilder());
			return this;
		}
		@Override 
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(List<? extends CalculationPeriod> calculationPeriods) {
			if (calculationPeriods != null) {
				for (CalculationPeriod toAdd : calculationPeriods) {
					this.calculationPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("calculationPeriod")
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setCalculationPeriod(List<? extends CalculationPeriod> calculationPeriods) {
			if (calculationPeriods == null)  {
				this.calculationPeriod = new ArrayList<>();
			}
			else {
				this.calculationPeriod = calculationPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("fixedPaymentAmount")
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setFixedPaymentAmount(BigDecimal fixedPaymentAmount) {
			this.fixedPaymentAmount = fixedPaymentAmount==null?null:fixedPaymentAmount;
			return this;
		}
		@Override
		@RosettaAttribute("discountFactor")
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		@RosettaAttribute("forecastPaymentAmount")
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setForecastPaymentAmount(Money forecastPaymentAmount) {
			this.forecastPaymentAmount = forecastPaymentAmount==null?null:forecastPaymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("presentValueAmount")
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setPresentValueAmount(Money presentValueAmount) {
			this.presentValueAmount = presentValueAmount==null?null:presentValueAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("href")
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod build() {
			return new PaymentCalculationPeriod.PaymentCalculationPeriodImpl(this);
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder prune() {
			calculationPeriod = calculationPeriod.stream().filter(b->b!=null).<CalculationPeriod.CalculationPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (forecastPaymentAmount!=null && !forecastPaymentAmount.prune().hasData()) forecastPaymentAmount = null;
			if (presentValueAmount!=null && !presentValueAmount.prune().hasData()) presentValueAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedPaymentDate()!=null) return true;
			if (getAdjustedPaymentDate()!=null) return true;
			if (getCalculationPeriod()!=null && getCalculationPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFixedPaymentAmount()!=null) return true;
			if (getDiscountFactor()!=null) return true;
			if (getForecastPaymentAmount()!=null && getForecastPaymentAmount().hasData()) return true;
			if (getPresentValueAmount()!=null && getPresentValueAmount().hasData()) return true;
			if (getId()!=null) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentCalculationPeriod.PaymentCalculationPeriodBuilder o = (PaymentCalculationPeriod.PaymentCalculationPeriodBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriod(), o.getCalculationPeriod(), this::getOrCreateCalculationPeriod);
			merger.mergeRosetta(getForecastPaymentAmount(), o.getForecastPaymentAmount(), this::setForecastPaymentAmount);
			merger.mergeRosetta(getPresentValueAmount(), o.getPresentValueAmount(), this::setPresentValueAmount);
			
			merger.mergeBasic(getUnadjustedPaymentDate(), o.getUnadjustedPaymentDate(), this::setUnadjustedPaymentDate);
			merger.mergeBasic(getAdjustedPaymentDate(), o.getAdjustedPaymentDate(), this::setAdjustedPaymentDate);
			merger.mergeBasic(getFixedPaymentAmount(), o.getFixedPaymentAmount(), this::setFixedPaymentAmount);
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedPaymentDate, _that.getUnadjustedPaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(fixedPaymentAmount, _that.getFixedPaymentAmount())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(forecastPaymentAmount, _that.getForecastPaymentAmount())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedPaymentDate != null ? unadjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (fixedPaymentAmount != null ? fixedPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (forecastPaymentAmount != null ? forecastPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentCalculationPeriodBuilder {" +
				"unadjustedPaymentDate=" + this.unadjustedPaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"fixedPaymentAmount=" + this.fixedPaymentAmount + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"forecastPaymentAmount=" + this.forecastPaymentAmount + ", " +
				"presentValueAmount=" + this.presentValueAmount + ", " +
				"id=" + this.id + ", " +
				"href=" + this.href +
			'}';
		}
	}
}
