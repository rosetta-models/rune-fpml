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
import fpml.confirmation.CommodityInformationProvider;
import fpml.confirmation.CommodityInformationProvider.CommodityInformationProviderBuilder;
import fpml.confirmation.CommodityInformationProvider.CommodityInformationProviderBuilderImpl;
import fpml.confirmation.CommodityInformationProvider.CommodityInformationProviderImpl;
import fpml.confirmation.meta.CommodityInformationProviderMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The publication in which the rate, price, index or factor is to be found. (e.g Gas Daily, Platts Bloomberg.)
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityInformationProvider", builder=CommodityInformationProvider.CommodityInformationProviderBuilderImpl.class, version="${project.version}")
public interface CommodityInformationProvider extends RosettaModelObject {

	CommodityInformationProviderMeta metaData = new CommodityInformationProviderMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getInformationProviderScheme();

	/*********************** Build Methods  ***********************/
	CommodityInformationProvider build();
	
	CommodityInformationProvider.CommodityInformationProviderBuilder toBuilder();
	
	static CommodityInformationProvider.CommodityInformationProviderBuilder builder() {
		return new CommodityInformationProvider.CommodityInformationProviderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityInformationProvider> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityInformationProvider> getType() {
		return CommodityInformationProvider.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("informationProviderScheme"), String.class, getInformationProviderScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityInformationProviderBuilder extends CommodityInformationProvider, RosettaModelObjectBuilder {
		CommodityInformationProvider.CommodityInformationProviderBuilder setValue(String value);
		CommodityInformationProvider.CommodityInformationProviderBuilder setInformationProviderScheme(String informationProviderScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("informationProviderScheme"), String.class, getInformationProviderScheme(), this);
		}
		

		CommodityInformationProvider.CommodityInformationProviderBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityInformationProvider  ***********************/
	class CommodityInformationProviderImpl implements CommodityInformationProvider {
		private final String value;
		private final String informationProviderScheme;
		
		protected CommodityInformationProviderImpl(CommodityInformationProvider.CommodityInformationProviderBuilder builder) {
			this.value = builder.getValue();
			this.informationProviderScheme = builder.getInformationProviderScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("informationProviderScheme")
		public String getInformationProviderScheme() {
			return informationProviderScheme;
		}
		
		@Override
		public CommodityInformationProvider build() {
			return this;
		}
		
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder toBuilder() {
			CommodityInformationProvider.CommodityInformationProviderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityInformationProvider.CommodityInformationProviderBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getInformationProviderScheme()).ifPresent(builder::setInformationProviderScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityInformationProvider _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(informationProviderScheme, _that.getInformationProviderScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (informationProviderScheme != null ? informationProviderScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityInformationProvider {" +
				"value=" + this.value + ", " +
				"informationProviderScheme=" + this.informationProviderScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityInformationProvider  ***********************/
	class CommodityInformationProviderBuilderImpl implements CommodityInformationProvider.CommodityInformationProviderBuilder {
	
		protected String value;
		protected String informationProviderScheme;
	
		public CommodityInformationProviderBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("informationProviderScheme")
		public String getInformationProviderScheme() {
			return informationProviderScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityInformationProvider.CommodityInformationProviderBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("informationProviderScheme")
		public CommodityInformationProvider.CommodityInformationProviderBuilder setInformationProviderScheme(String informationProviderScheme) {
			this.informationProviderScheme = informationProviderScheme==null?null:informationProviderScheme;
			return this;
		}
		
		@Override
		public CommodityInformationProvider build() {
			return new CommodityInformationProvider.CommodityInformationProviderImpl(this);
		}
		
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getInformationProviderScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityInformationProvider.CommodityInformationProviderBuilder o = (CommodityInformationProvider.CommodityInformationProviderBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getInformationProviderScheme(), o.getInformationProviderScheme(), this::setInformationProviderScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityInformationProvider _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(informationProviderScheme, _that.getInformationProviderScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (informationProviderScheme != null ? informationProviderScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityInformationProviderBuilder {" +
				"value=" + this.value + ", " +
				"informationProviderScheme=" + this.informationProviderScheme +
			'}';
		}
	}
}
