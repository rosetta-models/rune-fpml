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
import fpml.confirmation.Currency.CurrencyBuilder;
import fpml.confirmation.Currency.CurrencyBuilderImpl;
import fpml.confirmation.Currency.CurrencyImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.IdentifiedCurrency.IdentifiedCurrencyBuilder;
import fpml.confirmation.IdentifiedCurrency.IdentifiedCurrencyBuilderImpl;
import fpml.confirmation.IdentifiedCurrency.IdentifiedCurrencyImpl;
import fpml.confirmation.meta.IdentifiedCurrencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies Currency with ID attribute.
 * @version ${project.version}
 */
@RosettaDataType(value="IdentifiedCurrency", builder=IdentifiedCurrency.IdentifiedCurrencyBuilderImpl.class, version="${project.version}")
public interface IdentifiedCurrency extends Currency {

	IdentifiedCurrencyMeta metaData = new IdentifiedCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	IdentifiedCurrency build();
	
	IdentifiedCurrency.IdentifiedCurrencyBuilder toBuilder();
	
	static IdentifiedCurrency.IdentifiedCurrencyBuilder builder() {
		return new IdentifiedCurrency.IdentifiedCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedCurrency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IdentifiedCurrency> getType() {
		return IdentifiedCurrency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("currencyScheme"), String.class, getCurrencyScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedCurrencyBuilder extends IdentifiedCurrency, Currency.CurrencyBuilder {
		IdentifiedCurrency.IdentifiedCurrencyBuilder setValue(String value);
		IdentifiedCurrency.IdentifiedCurrencyBuilder setCurrencyScheme(String currencyScheme);
		IdentifiedCurrency.IdentifiedCurrencyBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("currencyScheme"), String.class, getCurrencyScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		IdentifiedCurrency.IdentifiedCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedCurrency  ***********************/
	class IdentifiedCurrencyImpl extends Currency.CurrencyImpl implements IdentifiedCurrency {
		private final String id;
		
		protected IdentifiedCurrencyImpl(IdentifiedCurrency.IdentifiedCurrencyBuilder builder) {
			super(builder);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public IdentifiedCurrency build() {
			return this;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder toBuilder() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedCurrency.IdentifiedCurrencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedCurrency {" +
				"id=" + this.id +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IdentifiedCurrency  ***********************/
	class IdentifiedCurrencyBuilderImpl extends Currency.CurrencyBuilderImpl  implements IdentifiedCurrency.IdentifiedCurrencyBuilder {
	
		protected String id;
	
		public IdentifiedCurrencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("currencyScheme")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder setCurrencyScheme(String currencyScheme) {
			this.currencyScheme = currencyScheme==null?null:currencyScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public IdentifiedCurrency build() {
			return new IdentifiedCurrency.IdentifiedCurrencyImpl(this);
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			IdentifiedCurrency.IdentifiedCurrencyBuilder o = (IdentifiedCurrency.IdentifiedCurrencyBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedCurrencyBuilder {" +
				"id=" + this.id +
			'}' + " " + super.toString();
		}
	}
}
