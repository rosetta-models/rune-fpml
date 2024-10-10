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
import fpml.confirmation.CreditLimit;
import fpml.confirmation.CreditLimit.CreditLimitBuilder;
import fpml.confirmation.CreditLimit.CreditLimitBuilderImpl;
import fpml.confirmation.CreditLimit.CreditLimitImpl;
import fpml.confirmation.CreditLimitBase;
import fpml.confirmation.CreditLimitBase.CreditLimitBaseBuilder;
import fpml.confirmation.CreditLimitBase.CreditLimitBaseBuilderImpl;
import fpml.confirmation.CreditLimitBase.CreditLimitBaseImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.LimitApplicable;
import fpml.confirmation.LimitId;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.CreditLimitMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a credit limit with applicability constraints.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditLimit", builder=CreditLimit.CreditLimitBuilderImpl.class, version="${project.version}")
public interface CreditLimit extends CreditLimitBase {

	CreditLimitMeta metaData = new CreditLimitMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends LimitApplicable> getLimitApplicable();
	ZonedDateTime getExpirationDate();

	/*********************** Build Methods  ***********************/
	CreditLimit build();
	
	CreditLimit.CreditLimitBuilder toBuilder();
	
	static CreditLimit.CreditLimitBuilder builder() {
		return new CreditLimit.CreditLimitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimit> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditLimit> getType() {
		return CreditLimit.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("limitId"), processor, LimitId.class, getLimitId());
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("tenor"), processor, Period.class, getTenor());
		processRosetta(path.newSubPath("limitApplicable"), processor, LimitApplicable.class, getLimitApplicable());
		processor.processBasic(path.newSubPath("expirationDate"), ZonedDateTime.class, getExpirationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitBuilder extends CreditLimit, CreditLimitBase.CreditLimitBaseBuilder {
		LimitApplicable.LimitApplicableBuilder getOrCreateLimitApplicable(int _index);
		List<? extends LimitApplicable.LimitApplicableBuilder> getLimitApplicable();
		CreditLimit.CreditLimitBuilder setLimitId(LimitId limitId);
		CreditLimit.CreditLimitBuilder setProductModel(ProductModel productModel);
		CreditLimit.CreditLimitBuilder setCurrency(Currency currency);
		CreditLimit.CreditLimitBuilder setTenor(Period tenor);
		CreditLimit.CreditLimitBuilder addLimitApplicable(LimitApplicable limitApplicable0);
		CreditLimit.CreditLimitBuilder addLimitApplicable(LimitApplicable limitApplicable1, int _idx);
		CreditLimit.CreditLimitBuilder addLimitApplicable(List<? extends LimitApplicable> limitApplicable2);
		CreditLimit.CreditLimitBuilder setLimitApplicable(List<? extends LimitApplicable> limitApplicable3);
		CreditLimit.CreditLimitBuilder setExpirationDate(ZonedDateTime expirationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("limitId"), processor, LimitId.LimitIdBuilder.class, getLimitId());
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("tenor"), processor, Period.PeriodBuilder.class, getTenor());
			processRosetta(path.newSubPath("limitApplicable"), processor, LimitApplicable.LimitApplicableBuilder.class, getLimitApplicable());
			processor.processBasic(path.newSubPath("expirationDate"), ZonedDateTime.class, getExpirationDate(), this);
		}
		

		CreditLimit.CreditLimitBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimit  ***********************/
	class CreditLimitImpl extends CreditLimitBase.CreditLimitBaseImpl implements CreditLimit {
		private final List<? extends LimitApplicable> limitApplicable;
		private final ZonedDateTime expirationDate;
		
		protected CreditLimitImpl(CreditLimit.CreditLimitBuilder builder) {
			super(builder);
			this.limitApplicable = ofNullable(builder.getLimitApplicable()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.expirationDate = builder.getExpirationDate();
		}
		
		@Override
		@RosettaAttribute("limitApplicable")
		public List<? extends LimitApplicable> getLimitApplicable() {
			return limitApplicable;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public ZonedDateTime getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public CreditLimit build() {
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder toBuilder() {
			CreditLimit.CreditLimitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimit.CreditLimitBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLimitApplicable()).ifPresent(builder::setLimitApplicable);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditLimit _that = getType().cast(o);
		
			if (!ListEquals.listEquals(limitApplicable, _that.getLimitApplicable())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (limitApplicable != null ? limitApplicable.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimit {" +
				"limitApplicable=" + this.limitApplicable + ", " +
				"expirationDate=" + this.expirationDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditLimit  ***********************/
	class CreditLimitBuilderImpl extends CreditLimitBase.CreditLimitBaseBuilderImpl  implements CreditLimit.CreditLimitBuilder {
	
		protected List<LimitApplicable.LimitApplicableBuilder> limitApplicable = new ArrayList<>();
		protected ZonedDateTime expirationDate;
	
		public CreditLimitBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("limitApplicable")
		public List<? extends LimitApplicable.LimitApplicableBuilder> getLimitApplicable() {
			return limitApplicable;
		}
		
		public LimitApplicable.LimitApplicableBuilder getOrCreateLimitApplicable(int _index) {
		
			if (limitApplicable==null) {
				this.limitApplicable = new ArrayList<>();
			}
			LimitApplicable.LimitApplicableBuilder result;
			return getIndex(limitApplicable, _index, () -> {
						LimitApplicable.LimitApplicableBuilder newLimitApplicable = LimitApplicable.builder();
						return newLimitApplicable;
					});
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public ZonedDateTime getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("limitId")
		public CreditLimit.CreditLimitBuilder setLimitId(LimitId limitId) {
			this.limitId = limitId==null?null:limitId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("productModel")
		public CreditLimit.CreditLimitBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public CreditLimit.CreditLimitBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tenor")
		public CreditLimit.CreditLimitBuilder setTenor(Period tenor) {
			this.tenor = tenor==null?null:tenor.toBuilder();
			return this;
		}
		@Override
		public CreditLimit.CreditLimitBuilder addLimitApplicable(LimitApplicable limitApplicable) {
			if (limitApplicable!=null) this.limitApplicable.add(limitApplicable.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder addLimitApplicable(LimitApplicable limitApplicable, int _idx) {
			getIndex(this.limitApplicable, _idx, () -> limitApplicable.toBuilder());
			return this;
		}
		@Override 
		public CreditLimit.CreditLimitBuilder addLimitApplicable(List<? extends LimitApplicable> limitApplicables) {
			if (limitApplicables != null) {
				for (LimitApplicable toAdd : limitApplicables) {
					this.limitApplicable.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("limitApplicable")
		public CreditLimit.CreditLimitBuilder setLimitApplicable(List<? extends LimitApplicable> limitApplicables) {
			if (limitApplicables == null)  {
				this.limitApplicable = new ArrayList<>();
			}
			else {
				this.limitApplicable = limitApplicables.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public CreditLimit.CreditLimitBuilder setExpirationDate(ZonedDateTime expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate;
			return this;
		}
		
		@Override
		public CreditLimit build() {
			return new CreditLimit.CreditLimitImpl(this);
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimit.CreditLimitBuilder prune() {
			super.prune();
			limitApplicable = limitApplicable.stream().filter(b->b!=null).<LimitApplicable.LimitApplicableBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLimitApplicable()!=null && getLimitApplicable().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExpirationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimit.CreditLimitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditLimit.CreditLimitBuilder o = (CreditLimit.CreditLimitBuilder) other;
			
			merger.mergeRosetta(getLimitApplicable(), o.getLimitApplicable(), this::getOrCreateLimitApplicable);
			
			merger.mergeBasic(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditLimit _that = getType().cast(o);
		
			if (!ListEquals.listEquals(limitApplicable, _that.getLimitApplicable())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (limitApplicable != null ? limitApplicable.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitBuilder {" +
				"limitApplicable=" + this.limitApplicable + ", " +
				"expirationDate=" + this.expirationDate +
			'}' + " " + super.toString();
		}
	}
}
