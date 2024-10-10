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
import fpml.confirmation.Currency;
import fpml.confirmation.MoneyBase;
import fpml.confirmation.MoneyBase.MoneyBaseBuilder;
import fpml.confirmation.MoneyBase.MoneyBaseBuilderImpl;
import fpml.confirmation.MoneyBase.MoneyBaseImpl;
import fpml.confirmation.meta.MoneyBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Abstract base class for all money types.
 * @version ${project.version}
 */
@RosettaDataType(value="MoneyBase", builder=MoneyBase.MoneyBaseBuilderImpl.class, version="${project.version}")
public interface MoneyBase extends RosettaModelObject {

	MoneyBaseMeta metaData = new MoneyBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which an amount is denominated.
	 */
	Currency getCurrency();
	String getId();

	/*********************** Build Methods  ***********************/
	MoneyBase build();
	
	MoneyBase.MoneyBaseBuilder toBuilder();
	
	static MoneyBase.MoneyBaseBuilder builder() {
		return new MoneyBase.MoneyBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MoneyBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MoneyBase> getType() {
		return MoneyBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MoneyBaseBuilder extends MoneyBase, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		MoneyBase.MoneyBaseBuilder setCurrency(Currency currency);
		MoneyBase.MoneyBaseBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		MoneyBase.MoneyBaseBuilder prune();
	}

	/*********************** Immutable Implementation of MoneyBase  ***********************/
	class MoneyBaseImpl implements MoneyBase {
		private final Currency currency;
		private final String id;
		
		protected MoneyBaseImpl(MoneyBase.MoneyBaseBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public MoneyBase build() {
			return this;
		}
		
		@Override
		public MoneyBase.MoneyBaseBuilder toBuilder() {
			MoneyBase.MoneyBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MoneyBase.MoneyBaseBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MoneyBase _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyBase {" +
				"currency=" + this.currency + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of MoneyBase  ***********************/
	class MoneyBaseBuilderImpl implements MoneyBase.MoneyBaseBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected String id;
	
		public MoneyBaseBuilderImpl() {
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
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("currency")
		public MoneyBase.MoneyBaseBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public MoneyBase.MoneyBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public MoneyBase build() {
			return new MoneyBase.MoneyBaseImpl(this);
		}
		
		@Override
		public MoneyBase.MoneyBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyBase.MoneyBaseBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyBase.MoneyBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MoneyBase.MoneyBaseBuilder o = (MoneyBase.MoneyBaseBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MoneyBase _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyBaseBuilder {" +
				"currency=" + this.currency + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
