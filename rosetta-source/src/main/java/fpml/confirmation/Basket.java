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
import fpml.confirmation.Asset;
import fpml.confirmation.Asset.AssetBuilder;
import fpml.confirmation.Asset.AssetBuilderImpl;
import fpml.confirmation.Asset.AssetImpl;
import fpml.confirmation.Basket;
import fpml.confirmation.Basket.BasketBuilder;
import fpml.confirmation.Basket.BasketBuilderImpl;
import fpml.confirmation.Basket.BasketImpl;
import fpml.confirmation.BasketConstituent;
import fpml.confirmation.BasketIdentifierModel;
import fpml.confirmation.Currency;
import fpml.confirmation.meta.BasketMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the underlying asset when it is a basket. A type describing the underlyer features of a basket swap. Each of the basket constituents are described through an embedded component, the basketConstituentsType.
 * @version ${project.version}
 */
@RosettaDataType(value="Basket", builder=Basket.BasketBuilderImpl.class, version="${project.version}")
public interface Basket extends Asset {

	BasketMeta metaData = new BasketMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of units (index or securities) that constitute the underlyer of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
	 */
	BigDecimal getOpenUnits();
	/**
	 * Describes each of the components of the basket.
	 */
	List<? extends BasketConstituent> getBasketConstituent();
	/**
	 * Specifies the basket divisor amount. This value is normally used to adjust the constituent weight for pricing or to adjust for dividends, or other corporate actions.
	 */
	BigDecimal getBasketDivisor();
	/**
	 * Basket version, used to record changes in basket composition or weights
	 */
	Integer getBasketVersion();
	BasketIdentifierModel getBasketIdentifierModel();
	/**
	 * Specifies the currency for this basket.
	 */
	Currency getBasketCurrency();

	/*********************** Build Methods  ***********************/
	Basket build();
	
	Basket.BasketBuilder toBuilder();
	
	static Basket.BasketBuilder builder() {
		return new Basket.BasketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Basket> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Basket> getType() {
		return Basket.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
		processRosetta(path.newSubPath("basketConstituent"), processor, BasketConstituent.class, getBasketConstituent());
		processor.processBasic(path.newSubPath("basketDivisor"), BigDecimal.class, getBasketDivisor(), this);
		processor.processBasic(path.newSubPath("basketVersion"), Integer.class, getBasketVersion(), this);
		processRosetta(path.newSubPath("basketIdentifierModel"), processor, BasketIdentifierModel.class, getBasketIdentifierModel());
		processRosetta(path.newSubPath("basketCurrency"), processor, Currency.class, getBasketCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketBuilder extends Basket, Asset.AssetBuilder {
		BasketConstituent.BasketConstituentBuilder getOrCreateBasketConstituent(int _index);
		List<? extends BasketConstituent.BasketConstituentBuilder> getBasketConstituent();
		BasketIdentifierModel.BasketIdentifierModelBuilder getOrCreateBasketIdentifierModel();
		BasketIdentifierModel.BasketIdentifierModelBuilder getBasketIdentifierModel();
		Currency.CurrencyBuilder getOrCreateBasketCurrency();
		Currency.CurrencyBuilder getBasketCurrency();
		Basket.BasketBuilder setId(String id);
		Basket.BasketBuilder setOpenUnits(BigDecimal openUnits);
		Basket.BasketBuilder addBasketConstituent(BasketConstituent basketConstituent0);
		Basket.BasketBuilder addBasketConstituent(BasketConstituent basketConstituent1, int _idx);
		Basket.BasketBuilder addBasketConstituent(List<? extends BasketConstituent> basketConstituent2);
		Basket.BasketBuilder setBasketConstituent(List<? extends BasketConstituent> basketConstituent3);
		Basket.BasketBuilder setBasketDivisor(BigDecimal basketDivisor);
		Basket.BasketBuilder setBasketVersion(Integer basketVersion);
		Basket.BasketBuilder setBasketIdentifierModel(BasketIdentifierModel basketIdentifierModel);
		Basket.BasketBuilder setBasketCurrency(Currency basketCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
			processRosetta(path.newSubPath("basketConstituent"), processor, BasketConstituent.BasketConstituentBuilder.class, getBasketConstituent());
			processor.processBasic(path.newSubPath("basketDivisor"), BigDecimal.class, getBasketDivisor(), this);
			processor.processBasic(path.newSubPath("basketVersion"), Integer.class, getBasketVersion(), this);
			processRosetta(path.newSubPath("basketIdentifierModel"), processor, BasketIdentifierModel.BasketIdentifierModelBuilder.class, getBasketIdentifierModel());
			processRosetta(path.newSubPath("basketCurrency"), processor, Currency.CurrencyBuilder.class, getBasketCurrency());
		}
		

		Basket.BasketBuilder prune();
	}

	/*********************** Immutable Implementation of Basket  ***********************/
	class BasketImpl extends Asset.AssetImpl implements Basket {
		private final BigDecimal openUnits;
		private final List<? extends BasketConstituent> basketConstituent;
		private final BigDecimal basketDivisor;
		private final Integer basketVersion;
		private final BasketIdentifierModel basketIdentifierModel;
		private final Currency basketCurrency;
		
		protected BasketImpl(Basket.BasketBuilder builder) {
			super(builder);
			this.openUnits = builder.getOpenUnits();
			this.basketConstituent = ofNullable(builder.getBasketConstituent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.basketDivisor = builder.getBasketDivisor();
			this.basketVersion = builder.getBasketVersion();
			this.basketIdentifierModel = ofNullable(builder.getBasketIdentifierModel()).map(f->f.build()).orElse(null);
			this.basketCurrency = ofNullable(builder.getBasketCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		public List<? extends BasketConstituent> getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		@RosettaAttribute("basketDivisor")
		public BigDecimal getBasketDivisor() {
			return basketDivisor;
		}
		
		@Override
		@RosettaAttribute("basketVersion")
		public Integer getBasketVersion() {
			return basketVersion;
		}
		
		@Override
		@RosettaAttribute("basketIdentifierModel")
		public BasketIdentifierModel getBasketIdentifierModel() {
			return basketIdentifierModel;
		}
		
		@Override
		@RosettaAttribute("basketCurrency")
		public Currency getBasketCurrency() {
			return basketCurrency;
		}
		
		@Override
		public Basket build() {
			return this;
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			Basket.BasketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Basket.BasketBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOpenUnits()).ifPresent(builder::setOpenUnits);
			ofNullable(getBasketConstituent()).ifPresent(builder::setBasketConstituent);
			ofNullable(getBasketDivisor()).ifPresent(builder::setBasketDivisor);
			ofNullable(getBasketVersion()).ifPresent(builder::setBasketVersion);
			ofNullable(getBasketIdentifierModel()).ifPresent(builder::setBasketIdentifierModel);
			ofNullable(getBasketCurrency()).ifPresent(builder::setBasketCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			if (!Objects.equals(basketDivisor, _that.getBasketDivisor())) return false;
			if (!Objects.equals(basketVersion, _that.getBasketVersion())) return false;
			if (!Objects.equals(basketIdentifierModel, _that.getBasketIdentifierModel())) return false;
			if (!Objects.equals(basketCurrency, _that.getBasketCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			_result = 31 * _result + (basketDivisor != null ? basketDivisor.hashCode() : 0);
			_result = 31 * _result + (basketVersion != null ? basketVersion.hashCode() : 0);
			_result = 31 * _result + (basketIdentifierModel != null ? basketIdentifierModel.hashCode() : 0);
			_result = 31 * _result + (basketCurrency != null ? basketCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Basket {" +
				"openUnits=" + this.openUnits + ", " +
				"basketConstituent=" + this.basketConstituent + ", " +
				"basketDivisor=" + this.basketDivisor + ", " +
				"basketVersion=" + this.basketVersion + ", " +
				"basketIdentifierModel=" + this.basketIdentifierModel + ", " +
				"basketCurrency=" + this.basketCurrency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Basket  ***********************/
	class BasketBuilderImpl extends Asset.AssetBuilderImpl  implements Basket.BasketBuilder {
	
		protected BigDecimal openUnits;
		protected List<BasketConstituent.BasketConstituentBuilder> basketConstituent = new ArrayList<>();
		protected BigDecimal basketDivisor;
		protected Integer basketVersion;
		protected BasketIdentifierModel.BasketIdentifierModelBuilder basketIdentifierModel;
		protected Currency.CurrencyBuilder basketCurrency;
	
		public BasketBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		public List<? extends BasketConstituent.BasketConstituentBuilder> getBasketConstituent() {
			return basketConstituent;
		}
		
		public BasketConstituent.BasketConstituentBuilder getOrCreateBasketConstituent(int _index) {
		
			if (basketConstituent==null) {
				this.basketConstituent = new ArrayList<>();
			}
			BasketConstituent.BasketConstituentBuilder result;
			return getIndex(basketConstituent, _index, () -> {
						BasketConstituent.BasketConstituentBuilder newBasketConstituent = BasketConstituent.builder();
						return newBasketConstituent;
					});
		}
		
		@Override
		@RosettaAttribute("basketDivisor")
		public BigDecimal getBasketDivisor() {
			return basketDivisor;
		}
		
		@Override
		@RosettaAttribute("basketVersion")
		public Integer getBasketVersion() {
			return basketVersion;
		}
		
		@Override
		@RosettaAttribute("basketIdentifierModel")
		public BasketIdentifierModel.BasketIdentifierModelBuilder getBasketIdentifierModel() {
			return basketIdentifierModel;
		}
		
		@Override
		public BasketIdentifierModel.BasketIdentifierModelBuilder getOrCreateBasketIdentifierModel() {
			BasketIdentifierModel.BasketIdentifierModelBuilder result;
			if (basketIdentifierModel!=null) {
				result = basketIdentifierModel;
			}
			else {
				result = basketIdentifierModel = BasketIdentifierModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketCurrency")
		public Currency.CurrencyBuilder getBasketCurrency() {
			return basketCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateBasketCurrency() {
			Currency.CurrencyBuilder result;
			if (basketCurrency!=null) {
				result = basketCurrency;
			}
			else {
				result = basketCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public Basket.BasketBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("openUnits")
		public Basket.BasketBuilder setOpenUnits(BigDecimal openUnits) {
			this.openUnits = openUnits==null?null:openUnits;
			return this;
		}
		@Override
		public Basket.BasketBuilder addBasketConstituent(BasketConstituent basketConstituent) {
			if (basketConstituent!=null) this.basketConstituent.add(basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituent(BasketConstituent basketConstituent, int _idx) {
			getIndex(this.basketConstituent, _idx, () -> basketConstituent.toBuilder());
			return this;
		}
		@Override 
		public Basket.BasketBuilder addBasketConstituent(List<? extends BasketConstituent> basketConstituents) {
			if (basketConstituents != null) {
				for (BasketConstituent toAdd : basketConstituents) {
					this.basketConstituent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("basketConstituent")
		public Basket.BasketBuilder setBasketConstituent(List<? extends BasketConstituent> basketConstituents) {
			if (basketConstituents == null)  {
				this.basketConstituent = new ArrayList<>();
			}
			else {
				this.basketConstituent = basketConstituents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("basketDivisor")
		public Basket.BasketBuilder setBasketDivisor(BigDecimal basketDivisor) {
			this.basketDivisor = basketDivisor==null?null:basketDivisor;
			return this;
		}
		@Override
		@RosettaAttribute("basketVersion")
		public Basket.BasketBuilder setBasketVersion(Integer basketVersion) {
			this.basketVersion = basketVersion==null?null:basketVersion;
			return this;
		}
		@Override
		@RosettaAttribute("basketIdentifierModel")
		public Basket.BasketBuilder setBasketIdentifierModel(BasketIdentifierModel basketIdentifierModel) {
			this.basketIdentifierModel = basketIdentifierModel==null?null:basketIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("basketCurrency")
		public Basket.BasketBuilder setBasketCurrency(Currency basketCurrency) {
			this.basketCurrency = basketCurrency==null?null:basketCurrency.toBuilder();
			return this;
		}
		
		@Override
		public Basket build() {
			return new Basket.BasketImpl(this);
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder prune() {
			super.prune();
			basketConstituent = basketConstituent.stream().filter(b->b!=null).<BasketConstituent.BasketConstituentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (basketIdentifierModel!=null && !basketIdentifierModel.prune().hasData()) basketIdentifierModel = null;
			if (basketCurrency!=null && !basketCurrency.prune().hasData()) basketCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOpenUnits()!=null) return true;
			if (getBasketConstituent()!=null && getBasketConstituent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBasketDivisor()!=null) return true;
			if (getBasketVersion()!=null) return true;
			if (getBasketIdentifierModel()!=null && getBasketIdentifierModel().hasData()) return true;
			if (getBasketCurrency()!=null && getBasketCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Basket.BasketBuilder o = (Basket.BasketBuilder) other;
			
			merger.mergeRosetta(getBasketConstituent(), o.getBasketConstituent(), this::getOrCreateBasketConstituent);
			merger.mergeRosetta(getBasketIdentifierModel(), o.getBasketIdentifierModel(), this::setBasketIdentifierModel);
			merger.mergeRosetta(getBasketCurrency(), o.getBasketCurrency(), this::setBasketCurrency);
			
			merger.mergeBasic(getOpenUnits(), o.getOpenUnits(), this::setOpenUnits);
			merger.mergeBasic(getBasketDivisor(), o.getBasketDivisor(), this::setBasketDivisor);
			merger.mergeBasic(getBasketVersion(), o.getBasketVersion(), this::setBasketVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			if (!Objects.equals(basketDivisor, _that.getBasketDivisor())) return false;
			if (!Objects.equals(basketVersion, _that.getBasketVersion())) return false;
			if (!Objects.equals(basketIdentifierModel, _that.getBasketIdentifierModel())) return false;
			if (!Objects.equals(basketCurrency, _that.getBasketCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			_result = 31 * _result + (basketDivisor != null ? basketDivisor.hashCode() : 0);
			_result = 31 * _result + (basketVersion != null ? basketVersion.hashCode() : 0);
			_result = 31 * _result + (basketIdentifierModel != null ? basketIdentifierModel.hashCode() : 0);
			_result = 31 * _result + (basketCurrency != null ? basketCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketBuilder {" +
				"openUnits=" + this.openUnits + ", " +
				"basketConstituent=" + this.basketConstituent + ", " +
				"basketDivisor=" + this.basketDivisor + ", " +
				"basketVersion=" + this.basketVersion + ", " +
				"basketIdentifierModel=" + this.basketIdentifierModel + ", " +
				"basketCurrency=" + this.basketCurrency +
			'}' + " " + super.toString();
		}
	}
}
