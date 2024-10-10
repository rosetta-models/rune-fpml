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
import fpml.confirmation.SettlementTerms;
import fpml.confirmation.SettlementTerms.SettlementTermsBuilder;
import fpml.confirmation.SettlementTerms.SettlementTermsBuilderImpl;
import fpml.confirmation.SettlementTerms.SettlementTermsImpl;
import fpml.confirmation.meta.SettlementTermsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementTerms", builder=SettlementTerms.SettlementTermsBuilderImpl.class, version="${project.version}")
public interface SettlementTerms extends RosettaModelObject {

	SettlementTermsMeta metaData = new SettlementTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * ISDA 2003 Term: Settlement Currency
	 */
	Currency getSettlementCurrency();
	String getId();

	/*********************** Build Methods  ***********************/
	SettlementTerms build();
	
	SettlementTerms.SettlementTermsBuilder toBuilder();
	
	static SettlementTerms.SettlementTermsBuilder builder() {
		return new SettlementTerms.SettlementTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementTerms> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementTerms> getType() {
		return SettlementTerms.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementTermsBuilder extends SettlementTerms, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		Currency.CurrencyBuilder getSettlementCurrency();
		SettlementTerms.SettlementTermsBuilder setSettlementCurrency(Currency settlementCurrency);
		SettlementTerms.SettlementTermsBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SettlementTerms.SettlementTermsBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementTerms  ***********************/
	class SettlementTermsImpl implements SettlementTerms {
		private final Currency settlementCurrency;
		private final String id;
		
		protected SettlementTermsImpl(SettlementTerms.SettlementTermsBuilder builder) {
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SettlementTerms build() {
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder toBuilder() {
			SettlementTerms.SettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementTerms.SettlementTermsBuilder builder) {
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementTerms {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementTerms  ***********************/
	class SettlementTermsBuilderImpl implements SettlementTerms.SettlementTermsBuilder {
	
		protected Currency.CurrencyBuilder settlementCurrency;
		protected String id;
	
		public SettlementTermsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public SettlementTerms.SettlementTermsBuilder setSettlementCurrency(Currency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public SettlementTerms.SettlementTermsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SettlementTerms build() {
			return new SettlementTerms.SettlementTermsImpl(this);
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementTerms.SettlementTermsBuilder prune() {
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementTerms.SettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementTerms.SettlementTermsBuilder o = (SettlementTerms.SettlementTermsBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementTermsBuilder {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
