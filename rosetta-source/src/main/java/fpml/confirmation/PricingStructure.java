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
import fpml.confirmation.PricingStructure;
import fpml.confirmation.PricingStructure.PricingStructureBuilder;
import fpml.confirmation.PricingStructure.PricingStructureBuilderImpl;
import fpml.confirmation.PricingStructure.PricingStructureImpl;
import fpml.confirmation.meta.PricingStructureMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract pricing structure base type. Used as a base for structures such as yield curves and volatility matrices.
 * @version ${project.version}
 */
@RosettaDataType(value="PricingStructure", builder=PricingStructure.PricingStructureBuilderImpl.class, version="${project.version}")
public interface PricingStructure extends RosettaModelObject {

	PricingStructureMeta metaData = new PricingStructureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the structure, e.g &quot;USDLIBOR-3M EOD Curve&quot;.
	 */
	String getName();
	/**
	 * The currency that the structure is expressed in (this is relevant mostly for the Interes Rates asset class).
	 */
	Currency getCurrency();
	String getId();

	/*********************** Build Methods  ***********************/
	PricingStructure build();
	
	PricingStructure.PricingStructureBuilder toBuilder();
	
	static PricingStructure.PricingStructureBuilder builder() {
		return new PricingStructure.PricingStructureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingStructure> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingStructure> getType() {
		return PricingStructure.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingStructureBuilder extends PricingStructure, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		PricingStructure.PricingStructureBuilder setName(String name);
		PricingStructure.PricingStructureBuilder setCurrency(Currency currency);
		PricingStructure.PricingStructureBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PricingStructure.PricingStructureBuilder prune();
	}

	/*********************** Immutable Implementation of PricingStructure  ***********************/
	class PricingStructureImpl implements PricingStructure {
		private final String name;
		private final Currency currency;
		private final String id;
		
		protected PricingStructureImpl(PricingStructure.PricingStructureBuilder builder) {
			this.name = builder.getName();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
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
		public PricingStructure build() {
			return this;
		}
		
		@Override
		public PricingStructure.PricingStructureBuilder toBuilder() {
			PricingStructure.PricingStructureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingStructure.PricingStructureBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructure _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructure {" +
				"name=" + this.name + ", " +
				"currency=" + this.currency + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingStructure  ***********************/
	class PricingStructureBuilderImpl implements PricingStructure.PricingStructureBuilder {
	
		protected String name;
		protected Currency.CurrencyBuilder currency;
		protected String id;
	
		public PricingStructureBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
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
		@RosettaAttribute("name")
		public PricingStructure.PricingStructureBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public PricingStructure.PricingStructureBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PricingStructure.PricingStructureBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PricingStructure build() {
			return new PricingStructure.PricingStructureImpl(this);
		}
		
		@Override
		public PricingStructure.PricingStructureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructure.PricingStructureBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructure.PricingStructureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingStructure.PricingStructureBuilder o = (PricingStructure.PricingStructureBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructure _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructureBuilder {" +
				"name=" + this.name + ", " +
				"currency=" + this.currency + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
