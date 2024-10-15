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
import fpml.confirmation.AmountReference;
import fpml.confirmation.Commission;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.Price;
import fpml.confirmation.Price.PriceBuilder;
import fpml.confirmation.Price.PriceBuilderImpl;
import fpml.confirmation.Price.PriceImpl;
import fpml.confirmation.PriceSequence;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.meta.PriceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the strike price.
 * @version ${project.version}
 */
@RosettaDataType(value="Price", builder=Price.PriceBuilderImpl.class, version="${project.version}")
public interface Price extends RosettaModelObject {

	PriceMeta metaData = new PriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This optional component specifies the commission to be charged for executing the hedge transactions.
	 */
	Commission getCommission();
	PriceSequence getPriceSequence();
	/**
	 * The href attribute value will be a pointer style reference to the element or component elsewhere in the document where the anchor amount is defined.
	 */
	AmountReference getAmountRelativeTo();
	EquityPriceModel getEquityPriceModel();
	/**
	 * The net price excluding accrued interest. The &quot;Dirty Price&quot; for bonds is put in the &quot;netPrice&quot; element, which includes accrued interest. Thus netPrice - cleanNetPrice = accruedInterest. The currency and price expression for this field are the same as those for the (dirty) netPrice.
	 */
	BigDecimal getCleanNetPrice();
	/**
	 * Allows information about how the price was quoted to be provided.
	 */
	QuotationCharacteristics getQuotationCharacteristics();

	/*********************** Build Methods  ***********************/
	Price build();
	
	Price.PriceBuilder toBuilder();
	
	static Price.PriceBuilder builder() {
		return new Price.PriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Price> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Price> getType() {
		return Price.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commission"), processor, Commission.class, getCommission());
		processRosetta(path.newSubPath("priceSequence"), processor, PriceSequence.class, getPriceSequence());
		processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.class, getAmountRelativeTo());
		processRosetta(path.newSubPath("equityPriceModel"), processor, EquityPriceModel.class, getEquityPriceModel());
		processor.processBasic(path.newSubPath("cleanNetPrice"), BigDecimal.class, getCleanNetPrice(), this);
		processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.class, getQuotationCharacteristics());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceBuilder extends Price, RosettaModelObjectBuilder {
		Commission.CommissionBuilder getOrCreateCommission();
		Commission.CommissionBuilder getCommission();
		PriceSequence.PriceSequenceBuilder getOrCreatePriceSequence();
		PriceSequence.PriceSequenceBuilder getPriceSequence();
		AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo();
		AmountReference.AmountReferenceBuilder getAmountRelativeTo();
		EquityPriceModel.EquityPriceModelBuilder getOrCreateEquityPriceModel();
		EquityPriceModel.EquityPriceModelBuilder getEquityPriceModel();
		QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateQuotationCharacteristics();
		QuotationCharacteristics.QuotationCharacteristicsBuilder getQuotationCharacteristics();
		Price.PriceBuilder setCommission(Commission commission);
		Price.PriceBuilder setPriceSequence(PriceSequence priceSequence);
		Price.PriceBuilder setAmountRelativeTo(AmountReference amountRelativeTo);
		Price.PriceBuilder setEquityPriceModel(EquityPriceModel equityPriceModel);
		Price.PriceBuilder setCleanNetPrice(BigDecimal cleanNetPrice);
		Price.PriceBuilder setQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commission"), processor, Commission.CommissionBuilder.class, getCommission());
			processRosetta(path.newSubPath("priceSequence"), processor, PriceSequence.PriceSequenceBuilder.class, getPriceSequence());
			processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.AmountReferenceBuilder.class, getAmountRelativeTo());
			processRosetta(path.newSubPath("equityPriceModel"), processor, EquityPriceModel.EquityPriceModelBuilder.class, getEquityPriceModel());
			processor.processBasic(path.newSubPath("cleanNetPrice"), BigDecimal.class, getCleanNetPrice(), this);
			processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.QuotationCharacteristicsBuilder.class, getQuotationCharacteristics());
		}
		

		Price.PriceBuilder prune();
	}

	/*********************** Immutable Implementation of Price  ***********************/
	class PriceImpl implements Price {
		private final Commission commission;
		private final PriceSequence priceSequence;
		private final AmountReference amountRelativeTo;
		private final EquityPriceModel equityPriceModel;
		private final BigDecimal cleanNetPrice;
		private final QuotationCharacteristics quotationCharacteristics;
		
		protected PriceImpl(Price.PriceBuilder builder) {
			this.commission = ofNullable(builder.getCommission()).map(f->f.build()).orElse(null);
			this.priceSequence = ofNullable(builder.getPriceSequence()).map(f->f.build()).orElse(null);
			this.amountRelativeTo = ofNullable(builder.getAmountRelativeTo()).map(f->f.build()).orElse(null);
			this.equityPriceModel = ofNullable(builder.getEquityPriceModel()).map(f->f.build()).orElse(null);
			this.cleanNetPrice = builder.getCleanNetPrice();
			this.quotationCharacteristics = ofNullable(builder.getQuotationCharacteristics()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commission")
		public Commission getCommission() {
			return commission;
		}
		
		@Override
		@RosettaAttribute("priceSequence")
		public PriceSequence getPriceSequence() {
			return priceSequence;
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		public AmountReference getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		@RosettaAttribute("equityPriceModel")
		public EquityPriceModel getEquityPriceModel() {
			return equityPriceModel;
		}
		
		@Override
		@RosettaAttribute("cleanNetPrice")
		public BigDecimal getCleanNetPrice() {
			return cleanNetPrice;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristics")
		public QuotationCharacteristics getQuotationCharacteristics() {
			return quotationCharacteristics;
		}
		
		@Override
		public Price build() {
			return this;
		}
		
		@Override
		public Price.PriceBuilder toBuilder() {
			Price.PriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Price.PriceBuilder builder) {
			ofNullable(getCommission()).ifPresent(builder::setCommission);
			ofNullable(getPriceSequence()).ifPresent(builder::setPriceSequence);
			ofNullable(getAmountRelativeTo()).ifPresent(builder::setAmountRelativeTo);
			ofNullable(getEquityPriceModel()).ifPresent(builder::setEquityPriceModel);
			ofNullable(getCleanNetPrice()).ifPresent(builder::setCleanNetPrice);
			ofNullable(getQuotationCharacteristics()).ifPresent(builder::setQuotationCharacteristics);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Price _that = getType().cast(o);
		
			if (!Objects.equals(commission, _that.getCommission())) return false;
			if (!Objects.equals(priceSequence, _that.getPriceSequence())) return false;
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!Objects.equals(equityPriceModel, _that.getEquityPriceModel())) return false;
			if (!Objects.equals(cleanNetPrice, _that.getCleanNetPrice())) return false;
			if (!Objects.equals(quotationCharacteristics, _that.getQuotationCharacteristics())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commission != null ? commission.hashCode() : 0);
			_result = 31 * _result + (priceSequence != null ? priceSequence.hashCode() : 0);
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (equityPriceModel != null ? equityPriceModel.hashCode() : 0);
			_result = 31 * _result + (cleanNetPrice != null ? cleanNetPrice.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristics != null ? quotationCharacteristics.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Price {" +
				"commission=" + this.commission + ", " +
				"priceSequence=" + this.priceSequence + ", " +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"equityPriceModel=" + this.equityPriceModel + ", " +
				"cleanNetPrice=" + this.cleanNetPrice + ", " +
				"quotationCharacteristics=" + this.quotationCharacteristics +
			'}';
		}
	}

	/*********************** Builder Implementation of Price  ***********************/
	class PriceBuilderImpl implements Price.PriceBuilder {
	
		protected Commission.CommissionBuilder commission;
		protected PriceSequence.PriceSequenceBuilder priceSequence;
		protected AmountReference.AmountReferenceBuilder amountRelativeTo;
		protected EquityPriceModel.EquityPriceModelBuilder equityPriceModel;
		protected BigDecimal cleanNetPrice;
		protected QuotationCharacteristics.QuotationCharacteristicsBuilder quotationCharacteristics;
	
		public PriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commission")
		public Commission.CommissionBuilder getCommission() {
			return commission;
		}
		
		@Override
		public Commission.CommissionBuilder getOrCreateCommission() {
			Commission.CommissionBuilder result;
			if (commission!=null) {
				result = commission;
			}
			else {
				result = commission = Commission.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceSequence")
		public PriceSequence.PriceSequenceBuilder getPriceSequence() {
			return priceSequence;
		}
		
		@Override
		public PriceSequence.PriceSequenceBuilder getOrCreatePriceSequence() {
			PriceSequence.PriceSequenceBuilder result;
			if (priceSequence!=null) {
				result = priceSequence;
			}
			else {
				result = priceSequence = PriceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		public AmountReference.AmountReferenceBuilder getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo() {
			AmountReference.AmountReferenceBuilder result;
			if (amountRelativeTo!=null) {
				result = amountRelativeTo;
			}
			else {
				result = amountRelativeTo = AmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityPriceModel")
		public EquityPriceModel.EquityPriceModelBuilder getEquityPriceModel() {
			return equityPriceModel;
		}
		
		@Override
		public EquityPriceModel.EquityPriceModelBuilder getOrCreateEquityPriceModel() {
			EquityPriceModel.EquityPriceModelBuilder result;
			if (equityPriceModel!=null) {
				result = equityPriceModel;
			}
			else {
				result = equityPriceModel = EquityPriceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cleanNetPrice")
		public BigDecimal getCleanNetPrice() {
			return cleanNetPrice;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristics")
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getQuotationCharacteristics() {
			return quotationCharacteristics;
		}
		
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateQuotationCharacteristics() {
			QuotationCharacteristics.QuotationCharacteristicsBuilder result;
			if (quotationCharacteristics!=null) {
				result = quotationCharacteristics;
			}
			else {
				result = quotationCharacteristics = QuotationCharacteristics.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commission")
		public Price.PriceBuilder setCommission(Commission commission) {
			this.commission = commission==null?null:commission.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("priceSequence")
		public Price.PriceBuilder setPriceSequence(PriceSequence priceSequence) {
			this.priceSequence = priceSequence==null?null:priceSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amountRelativeTo")
		public Price.PriceBuilder setAmountRelativeTo(AmountReference amountRelativeTo) {
			this.amountRelativeTo = amountRelativeTo==null?null:amountRelativeTo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityPriceModel")
		public Price.PriceBuilder setEquityPriceModel(EquityPriceModel equityPriceModel) {
			this.equityPriceModel = equityPriceModel==null?null:equityPriceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cleanNetPrice")
		public Price.PriceBuilder setCleanNetPrice(BigDecimal cleanNetPrice) {
			this.cleanNetPrice = cleanNetPrice==null?null:cleanNetPrice;
			return this;
		}
		@Override
		@RosettaAttribute("quotationCharacteristics")
		public Price.PriceBuilder setQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics) {
			this.quotationCharacteristics = quotationCharacteristics==null?null:quotationCharacteristics.toBuilder();
			return this;
		}
		
		@Override
		public Price build() {
			return new Price.PriceImpl(this);
		}
		
		@Override
		public Price.PriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Price.PriceBuilder prune() {
			if (commission!=null && !commission.prune().hasData()) commission = null;
			if (priceSequence!=null && !priceSequence.prune().hasData()) priceSequence = null;
			if (amountRelativeTo!=null && !amountRelativeTo.prune().hasData()) amountRelativeTo = null;
			if (equityPriceModel!=null && !equityPriceModel.prune().hasData()) equityPriceModel = null;
			if (quotationCharacteristics!=null && !quotationCharacteristics.prune().hasData()) quotationCharacteristics = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommission()!=null && getCommission().hasData()) return true;
			if (getPriceSequence()!=null && getPriceSequence().hasData()) return true;
			if (getAmountRelativeTo()!=null && getAmountRelativeTo().hasData()) return true;
			if (getEquityPriceModel()!=null && getEquityPriceModel().hasData()) return true;
			if (getCleanNetPrice()!=null) return true;
			if (getQuotationCharacteristics()!=null && getQuotationCharacteristics().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Price.PriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Price.PriceBuilder o = (Price.PriceBuilder) other;
			
			merger.mergeRosetta(getCommission(), o.getCommission(), this::setCommission);
			merger.mergeRosetta(getPriceSequence(), o.getPriceSequence(), this::setPriceSequence);
			merger.mergeRosetta(getAmountRelativeTo(), o.getAmountRelativeTo(), this::setAmountRelativeTo);
			merger.mergeRosetta(getEquityPriceModel(), o.getEquityPriceModel(), this::setEquityPriceModel);
			merger.mergeRosetta(getQuotationCharacteristics(), o.getQuotationCharacteristics(), this::setQuotationCharacteristics);
			
			merger.mergeBasic(getCleanNetPrice(), o.getCleanNetPrice(), this::setCleanNetPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Price _that = getType().cast(o);
		
			if (!Objects.equals(commission, _that.getCommission())) return false;
			if (!Objects.equals(priceSequence, _that.getPriceSequence())) return false;
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!Objects.equals(equityPriceModel, _that.getEquityPriceModel())) return false;
			if (!Objects.equals(cleanNetPrice, _that.getCleanNetPrice())) return false;
			if (!Objects.equals(quotationCharacteristics, _that.getQuotationCharacteristics())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commission != null ? commission.hashCode() : 0);
			_result = 31 * _result + (priceSequence != null ? priceSequence.hashCode() : 0);
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (equityPriceModel != null ? equityPriceModel.hashCode() : 0);
			_result = 31 * _result + (cleanNetPrice != null ? cleanNetPrice.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristics != null ? quotationCharacteristics.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceBuilder {" +
				"commission=" + this.commission + ", " +
				"priceSequence=" + this.priceSequence + ", " +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"equityPriceModel=" + this.equityPriceModel + ", " +
				"cleanNetPrice=" + this.cleanNetPrice + ", " +
				"quotationCharacteristics=" + this.quotationCharacteristics +
			'}';
		}
	}
}
