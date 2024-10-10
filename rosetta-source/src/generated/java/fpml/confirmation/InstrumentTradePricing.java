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
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.InstrumentTradePricing;
import fpml.confirmation.InstrumentTradePricing.InstrumentTradePricingBuilder;
import fpml.confirmation.InstrumentTradePricing.InstrumentTradePricingBuilderImpl;
import fpml.confirmation.InstrumentTradePricing.InstrumentTradePricingImpl;
import fpml.confirmation.meta.InstrumentTradePricingMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing the price paid for the instrument.
 * @version ${project.version}
 */
@RosettaDataType(value="InstrumentTradePricing", builder=InstrumentTradePricing.InstrumentTradePricingBuilderImpl.class, version="${project.version}")
public interface InstrumentTradePricing extends RosettaModelObject {

	InstrumentTradePricingMeta metaData = new InstrumentTradePricingMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends BasicQuotation> getQuote();
	/**
	 * The date interest started accruing for the accrued interest calculation on an interest bearing security.
	 */
	Date getCouponStartDate();
	/**
	 * The date when a distribution of dividends or interest is deducted from a securities asset, or set aside for payment to the original bondholders. From the ex-date, any dividends that are owing on the security are paid to the original owner. As a consequence of this, on the ex-date, the securities price typically drops by the amount of the distribution (plus or minus any market activity).
	 */
	Date getExDividendDate();
	/**
	 * Whether the accrued interest in included when the trade settles. (&quot;true&quot; means accrued interest is not included when the trade settles.)
	 */
	Boolean getTradedFlatOfAccrued();

	/*********************** Build Methods  ***********************/
	InstrumentTradePricing build();
	
	InstrumentTradePricing.InstrumentTradePricingBuilder toBuilder();
	
	static InstrumentTradePricing.InstrumentTradePricingBuilder builder() {
		return new InstrumentTradePricing.InstrumentTradePricingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentTradePricing> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InstrumentTradePricing> getType() {
		return InstrumentTradePricing.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
		processor.processBasic(path.newSubPath("couponStartDate"), Date.class, getCouponStartDate(), this);
		processor.processBasic(path.newSubPath("exDividendDate"), Date.class, getExDividendDate(), this);
		processor.processBasic(path.newSubPath("tradedFlatOfAccrued"), Boolean.class, getTradedFlatOfAccrued(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentTradePricingBuilder extends InstrumentTradePricing, RosettaModelObjectBuilder {
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int _index);
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(BasicQuotation quote0);
		InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(BasicQuotation quote1, int _idx);
		InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(List<? extends BasicQuotation> quote2);
		InstrumentTradePricing.InstrumentTradePricingBuilder setQuote(List<? extends BasicQuotation> quote3);
		InstrumentTradePricing.InstrumentTradePricingBuilder setCouponStartDate(Date couponStartDate);
		InstrumentTradePricing.InstrumentTradePricingBuilder setExDividendDate(Date exDividendDate);
		InstrumentTradePricing.InstrumentTradePricingBuilder setTradedFlatOfAccrued(Boolean tradedFlatOfAccrued);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
			processor.processBasic(path.newSubPath("couponStartDate"), Date.class, getCouponStartDate(), this);
			processor.processBasic(path.newSubPath("exDividendDate"), Date.class, getExDividendDate(), this);
			processor.processBasic(path.newSubPath("tradedFlatOfAccrued"), Boolean.class, getTradedFlatOfAccrued(), this);
		}
		

		InstrumentTradePricing.InstrumentTradePricingBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentTradePricing  ***********************/
	class InstrumentTradePricingImpl implements InstrumentTradePricing {
		private final List<? extends BasicQuotation> quote;
		private final Date couponStartDate;
		private final Date exDividendDate;
		private final Boolean tradedFlatOfAccrued;
		
		protected InstrumentTradePricingImpl(InstrumentTradePricing.InstrumentTradePricingBuilder builder) {
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.couponStartDate = builder.getCouponStartDate();
			this.exDividendDate = builder.getExDividendDate();
			this.tradedFlatOfAccrued = builder.getTradedFlatOfAccrued();
		}
		
		@Override
		@RosettaAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
		}
		
		@Override
		@RosettaAttribute("couponStartDate")
		public Date getCouponStartDate() {
			return couponStartDate;
		}
		
		@Override
		@RosettaAttribute("exDividendDate")
		public Date getExDividendDate() {
			return exDividendDate;
		}
		
		@Override
		@RosettaAttribute("tradedFlatOfAccrued")
		public Boolean getTradedFlatOfAccrued() {
			return tradedFlatOfAccrued;
		}
		
		@Override
		public InstrumentTradePricing build() {
			return this;
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder toBuilder() {
			InstrumentTradePricing.InstrumentTradePricingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentTradePricing.InstrumentTradePricingBuilder builder) {
			ofNullable(getQuote()).ifPresent(builder::setQuote);
			ofNullable(getCouponStartDate()).ifPresent(builder::setCouponStartDate);
			ofNullable(getExDividendDate()).ifPresent(builder::setExDividendDate);
			ofNullable(getTradedFlatOfAccrued()).ifPresent(builder::setTradedFlatOfAccrued);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentTradePricing _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!Objects.equals(couponStartDate, _that.getCouponStartDate())) return false;
			if (!Objects.equals(exDividendDate, _that.getExDividendDate())) return false;
			if (!Objects.equals(tradedFlatOfAccrued, _that.getTradedFlatOfAccrued())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (couponStartDate != null ? couponStartDate.hashCode() : 0);
			_result = 31 * _result + (exDividendDate != null ? exDividendDate.hashCode() : 0);
			_result = 31 * _result + (tradedFlatOfAccrued != null ? tradedFlatOfAccrued.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradePricing {" +
				"quote=" + this.quote + ", " +
				"couponStartDate=" + this.couponStartDate + ", " +
				"exDividendDate=" + this.exDividendDate + ", " +
				"tradedFlatOfAccrued=" + this.tradedFlatOfAccrued +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentTradePricing  ***********************/
	class InstrumentTradePricingBuilderImpl implements InstrumentTradePricing.InstrumentTradePricingBuilder {
	
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
		protected Date couponStartDate;
		protected Date exDividendDate;
		protected Boolean tradedFlatOfAccrued;
	
		public InstrumentTradePricingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int _index) {
		
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			BasicQuotation.BasicQuotationBuilder result;
			return getIndex(quote, _index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
		}
		
		@Override
		@RosettaAttribute("couponStartDate")
		public Date getCouponStartDate() {
			return couponStartDate;
		}
		
		@Override
		@RosettaAttribute("exDividendDate")
		public Date getExDividendDate() {
			return exDividendDate;
		}
		
		@Override
		@RosettaAttribute("tradedFlatOfAccrued")
		public Boolean getTradedFlatOfAccrued() {
			return tradedFlatOfAccrued;
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(BasicQuotation quote) {
			if (quote!=null) this.quote.add(quote.toBuilder());
			return this;
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(BasicQuotation quote, int _idx) {
			getIndex(this.quote, _idx, () -> quote.toBuilder());
			return this;
		}
		@Override 
		public InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("quote")
		public InstrumentTradePricing.InstrumentTradePricingBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null)  {
				this.quote = new ArrayList<>();
			}
			else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("couponStartDate")
		public InstrumentTradePricing.InstrumentTradePricingBuilder setCouponStartDate(Date couponStartDate) {
			this.couponStartDate = couponStartDate==null?null:couponStartDate;
			return this;
		}
		@Override
		@RosettaAttribute("exDividendDate")
		public InstrumentTradePricing.InstrumentTradePricingBuilder setExDividendDate(Date exDividendDate) {
			this.exDividendDate = exDividendDate==null?null:exDividendDate;
			return this;
		}
		@Override
		@RosettaAttribute("tradedFlatOfAccrued")
		public InstrumentTradePricing.InstrumentTradePricingBuilder setTradedFlatOfAccrued(Boolean tradedFlatOfAccrued) {
			this.tradedFlatOfAccrued = tradedFlatOfAccrued==null?null:tradedFlatOfAccrued;
			return this;
		}
		
		@Override
		public InstrumentTradePricing build() {
			return new InstrumentTradePricing.InstrumentTradePricingImpl(this);
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder prune() {
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCouponStartDate()!=null) return true;
			if (getExDividendDate()!=null) return true;
			if (getTradedFlatOfAccrued()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentTradePricing.InstrumentTradePricingBuilder o = (InstrumentTradePricing.InstrumentTradePricingBuilder) other;
			
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			
			merger.mergeBasic(getCouponStartDate(), o.getCouponStartDate(), this::setCouponStartDate);
			merger.mergeBasic(getExDividendDate(), o.getExDividendDate(), this::setExDividendDate);
			merger.mergeBasic(getTradedFlatOfAccrued(), o.getTradedFlatOfAccrued(), this::setTradedFlatOfAccrued);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentTradePricing _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!Objects.equals(couponStartDate, _that.getCouponStartDate())) return false;
			if (!Objects.equals(exDividendDate, _that.getExDividendDate())) return false;
			if (!Objects.equals(tradedFlatOfAccrued, _that.getTradedFlatOfAccrued())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (couponStartDate != null ? couponStartDate.hashCode() : 0);
			_result = 31 * _result + (exDividendDate != null ? exDividendDate.hashCode() : 0);
			_result = 31 * _result + (tradedFlatOfAccrued != null ? tradedFlatOfAccrued.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradePricingBuilder {" +
				"quote=" + this.quote + ", " +
				"couponStartDate=" + this.couponStartDate + ", " +
				"exDividendDate=" + this.exDividendDate + ", " +
				"tradedFlatOfAccrued=" + this.tradedFlatOfAccrued +
			'}';
		}
	}
}
