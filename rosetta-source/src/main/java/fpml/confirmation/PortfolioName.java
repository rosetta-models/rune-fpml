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
import fpml.confirmation.PortfolioName;
import fpml.confirmation.PortfolioName.PortfolioNameBuilder;
import fpml.confirmation.PortfolioName.PortfolioNameBuilderImpl;
import fpml.confirmation.PortfolioName.PortfolioNameImpl;
import fpml.confirmation.meta.PortfolioNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for portfolio names.
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioName", builder=PortfolioName.PortfolioNameBuilderImpl.class, version="${project.version}")
public interface PortfolioName extends RosettaModelObject {

	PortfolioNameMeta metaData = new PortfolioNameMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getId();
	String getPortfolioNameScheme();

	/*********************** Build Methods  ***********************/
	PortfolioName build();
	
	PortfolioName.PortfolioNameBuilder toBuilder();
	
	static PortfolioName.PortfolioNameBuilder builder() {
		return new PortfolioName.PortfolioNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PortfolioName> getType() {
		return PortfolioName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("portfolioNameScheme"), String.class, getPortfolioNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioNameBuilder extends PortfolioName, RosettaModelObjectBuilder {
		PortfolioName.PortfolioNameBuilder setValue(String value);
		PortfolioName.PortfolioNameBuilder setId(String id);
		PortfolioName.PortfolioNameBuilder setPortfolioNameScheme(String portfolioNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("portfolioNameScheme"), String.class, getPortfolioNameScheme(), this);
		}
		

		PortfolioName.PortfolioNameBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioName  ***********************/
	class PortfolioNameImpl implements PortfolioName {
		private final String value;
		private final String id;
		private final String portfolioNameScheme;
		
		protected PortfolioNameImpl(PortfolioName.PortfolioNameBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
			this.portfolioNameScheme = builder.getPortfolioNameScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("portfolioNameScheme")
		public String getPortfolioNameScheme() {
			return portfolioNameScheme;
		}
		
		@Override
		public PortfolioName build() {
			return this;
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder toBuilder() {
			PortfolioName.PortfolioNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioName.PortfolioNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPortfolioNameScheme()).ifPresent(builder::setPortfolioNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(portfolioNameScheme, _that.getPortfolioNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (portfolioNameScheme != null ? portfolioNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioName {" +
				"value=" + this.value + ", " +
				"id=" + this.id + ", " +
				"portfolioNameScheme=" + this.portfolioNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioName  ***********************/
	class PortfolioNameBuilderImpl implements PortfolioName.PortfolioNameBuilder {
	
		protected String value;
		protected String id;
		protected String portfolioNameScheme;
	
		public PortfolioNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("portfolioNameScheme")
		public String getPortfolioNameScheme() {
			return portfolioNameScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PortfolioName.PortfolioNameBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PortfolioName.PortfolioNameBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("portfolioNameScheme")
		public PortfolioName.PortfolioNameBuilder setPortfolioNameScheme(String portfolioNameScheme) {
			this.portfolioNameScheme = portfolioNameScheme==null?null:portfolioNameScheme;
			return this;
		}
		
		@Override
		public PortfolioName build() {
			return new PortfolioName.PortfolioNameImpl(this);
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioName.PortfolioNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			if (getPortfolioNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioName.PortfolioNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioName.PortfolioNameBuilder o = (PortfolioName.PortfolioNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getPortfolioNameScheme(), o.getPortfolioNameScheme(), this::setPortfolioNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(portfolioNameScheme, _that.getPortfolioNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (portfolioNameScheme != null ? portfolioNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioNameBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id + ", " +
				"portfolioNameScheme=" + this.portfolioNameScheme +
			'}';
		}
	}
}
