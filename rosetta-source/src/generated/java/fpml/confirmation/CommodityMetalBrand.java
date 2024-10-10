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
import fpml.confirmation.CommodityMetalBrand;
import fpml.confirmation.CommodityMetalBrand.CommodityMetalBrandBuilder;
import fpml.confirmation.CommodityMetalBrand.CommodityMetalBrandBuilderImpl;
import fpml.confirmation.CommodityMetalBrand.CommodityMetalBrandImpl;
import fpml.confirmation.CommodityMetalBrandManager;
import fpml.confirmation.CommodityMetalBrandName;
import fpml.confirmation.CommodityMetalProducer;
import fpml.confirmation.CountryCode;
import fpml.confirmation.meta.CommodityMetalBrandMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityMetalBrand", builder=CommodityMetalBrand.CommodityMetalBrandBuilderImpl.class, version="${project.version}")
public interface CommodityMetalBrand extends RosettaModelObject {

	CommodityMetalBrandMeta metaData = new CommodityMetalBrandMeta();

	/*********************** Getter Methods  ***********************/
	CommodityMetalBrandName getName();
	CommodityMetalBrandManager getBrandManager();
	CountryCode getCountry();
	CommodityMetalProducer getProducer();

	/*********************** Build Methods  ***********************/
	CommodityMetalBrand build();
	
	CommodityMetalBrand.CommodityMetalBrandBuilder toBuilder();
	
	static CommodityMetalBrand.CommodityMetalBrandBuilder builder() {
		return new CommodityMetalBrand.CommodityMetalBrandBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMetalBrand> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityMetalBrand> getType() {
		return CommodityMetalBrand.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("name"), processor, CommodityMetalBrandName.class, getName());
		processRosetta(path.newSubPath("brandManager"), processor, CommodityMetalBrandManager.class, getBrandManager());
		processRosetta(path.newSubPath("country"), processor, CountryCode.class, getCountry());
		processRosetta(path.newSubPath("producer"), processor, CommodityMetalProducer.class, getProducer());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMetalBrandBuilder extends CommodityMetalBrand, RosettaModelObjectBuilder {
		CommodityMetalBrandName.CommodityMetalBrandNameBuilder getOrCreateName();
		CommodityMetalBrandName.CommodityMetalBrandNameBuilder getName();
		CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder getOrCreateBrandManager();
		CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder getBrandManager();
		CountryCode.CountryCodeBuilder getOrCreateCountry();
		CountryCode.CountryCodeBuilder getCountry();
		CommodityMetalProducer.CommodityMetalProducerBuilder getOrCreateProducer();
		CommodityMetalProducer.CommodityMetalProducerBuilder getProducer();
		CommodityMetalBrand.CommodityMetalBrandBuilder setName(CommodityMetalBrandName name);
		CommodityMetalBrand.CommodityMetalBrandBuilder setBrandManager(CommodityMetalBrandManager brandManager);
		CommodityMetalBrand.CommodityMetalBrandBuilder setCountry(CountryCode country);
		CommodityMetalBrand.CommodityMetalBrandBuilder setProducer(CommodityMetalProducer producer);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("name"), processor, CommodityMetalBrandName.CommodityMetalBrandNameBuilder.class, getName());
			processRosetta(path.newSubPath("brandManager"), processor, CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder.class, getBrandManager());
			processRosetta(path.newSubPath("country"), processor, CountryCode.CountryCodeBuilder.class, getCountry());
			processRosetta(path.newSubPath("producer"), processor, CommodityMetalProducer.CommodityMetalProducerBuilder.class, getProducer());
		}
		

		CommodityMetalBrand.CommodityMetalBrandBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMetalBrand  ***********************/
	class CommodityMetalBrandImpl implements CommodityMetalBrand {
		private final CommodityMetalBrandName name;
		private final CommodityMetalBrandManager brandManager;
		private final CountryCode country;
		private final CommodityMetalProducer producer;
		
		protected CommodityMetalBrandImpl(CommodityMetalBrand.CommodityMetalBrandBuilder builder) {
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
			this.brandManager = ofNullable(builder.getBrandManager()).map(f->f.build()).orElse(null);
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
			this.producer = ofNullable(builder.getProducer()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		public CommodityMetalBrandName getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("brandManager")
		public CommodityMetalBrandManager getBrandManager() {
			return brandManager;
		}
		
		@Override
		@RosettaAttribute("country")
		public CountryCode getCountry() {
			return country;
		}
		
		@Override
		@RosettaAttribute("producer")
		public CommodityMetalProducer getProducer() {
			return producer;
		}
		
		@Override
		public CommodityMetalBrand build() {
			return this;
		}
		
		@Override
		public CommodityMetalBrand.CommodityMetalBrandBuilder toBuilder() {
			CommodityMetalBrand.CommodityMetalBrandBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMetalBrand.CommodityMetalBrandBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getBrandManager()).ifPresent(builder::setBrandManager);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
			ofNullable(getProducer()).ifPresent(builder::setProducer);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalBrand _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(brandManager, _that.getBrandManager())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(producer, _that.getProducer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (brandManager != null ? brandManager.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (producer != null ? producer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalBrand {" +
				"name=" + this.name + ", " +
				"brandManager=" + this.brandManager + ", " +
				"country=" + this.country + ", " +
				"producer=" + this.producer +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMetalBrand  ***********************/
	class CommodityMetalBrandBuilderImpl implements CommodityMetalBrand.CommodityMetalBrandBuilder {
	
		protected CommodityMetalBrandName.CommodityMetalBrandNameBuilder name;
		protected CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder brandManager;
		protected CountryCode.CountryCodeBuilder country;
		protected CommodityMetalProducer.CommodityMetalProducerBuilder producer;
	
		public CommodityMetalBrandBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public CommodityMetalBrandName.CommodityMetalBrandNameBuilder getName() {
			return name;
		}
		
		@Override
		public CommodityMetalBrandName.CommodityMetalBrandNameBuilder getOrCreateName() {
			CommodityMetalBrandName.CommodityMetalBrandNameBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = CommodityMetalBrandName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("brandManager")
		public CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder getBrandManager() {
			return brandManager;
		}
		
		@Override
		public CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder getOrCreateBrandManager() {
			CommodityMetalBrandManager.CommodityMetalBrandManagerBuilder result;
			if (brandManager!=null) {
				result = brandManager;
			}
			else {
				result = brandManager = CommodityMetalBrandManager.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("country")
		public CountryCode.CountryCodeBuilder getCountry() {
			return country;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateCountry() {
			CountryCode.CountryCodeBuilder result;
			if (country!=null) {
				result = country;
			}
			else {
				result = country = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("producer")
		public CommodityMetalProducer.CommodityMetalProducerBuilder getProducer() {
			return producer;
		}
		
		@Override
		public CommodityMetalProducer.CommodityMetalProducerBuilder getOrCreateProducer() {
			CommodityMetalProducer.CommodityMetalProducerBuilder result;
			if (producer!=null) {
				result = producer;
			}
			else {
				result = producer = CommodityMetalProducer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("name")
		public CommodityMetalBrand.CommodityMetalBrandBuilder setName(CommodityMetalBrandName name) {
			this.name = name==null?null:name.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("brandManager")
		public CommodityMetalBrand.CommodityMetalBrandBuilder setBrandManager(CommodityMetalBrandManager brandManager) {
			this.brandManager = brandManager==null?null:brandManager.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("country")
		public CommodityMetalBrand.CommodityMetalBrandBuilder setCountry(CountryCode country) {
			this.country = country==null?null:country.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("producer")
		public CommodityMetalBrand.CommodityMetalBrandBuilder setProducer(CommodityMetalProducer producer) {
			this.producer = producer==null?null:producer.toBuilder();
			return this;
		}
		
		@Override
		public CommodityMetalBrand build() {
			return new CommodityMetalBrand.CommodityMetalBrandImpl(this);
		}
		
		@Override
		public CommodityMetalBrand.CommodityMetalBrandBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalBrand.CommodityMetalBrandBuilder prune() {
			if (name!=null && !name.prune().hasData()) name = null;
			if (brandManager!=null && !brandManager.prune().hasData()) brandManager = null;
			if (country!=null && !country.prune().hasData()) country = null;
			if (producer!=null && !producer.prune().hasData()) producer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null && getName().hasData()) return true;
			if (getBrandManager()!=null && getBrandManager().hasData()) return true;
			if (getCountry()!=null && getCountry().hasData()) return true;
			if (getProducer()!=null && getProducer().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMetalBrand.CommodityMetalBrandBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMetalBrand.CommodityMetalBrandBuilder o = (CommodityMetalBrand.CommodityMetalBrandBuilder) other;
			
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			merger.mergeRosetta(getBrandManager(), o.getBrandManager(), this::setBrandManager);
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			merger.mergeRosetta(getProducer(), o.getProducer(), this::setProducer);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMetalBrand _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(brandManager, _that.getBrandManager())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(producer, _that.getProducer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (brandManager != null ? brandManager.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (producer != null ? producer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMetalBrandBuilder {" +
				"name=" + this.name + ", " +
				"brandManager=" + this.brandManager + ", " +
				"country=" + this.country + ", " +
				"producer=" + this.producer +
			'}';
		}
	}
}
