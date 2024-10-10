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
import fpml.confirmation.OrganizationType;
import fpml.confirmation.OrganizationType.OrganizationTypeBuilder;
import fpml.confirmation.OrganizationType.OrganizationTypeBuilderImpl;
import fpml.confirmation.OrganizationType.OrganizationTypeImpl;
import fpml.confirmation.meta.OrganizationTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A code that describes what type of role an organization plays, for example a SwapsDealer, a Major Swaps Participant, or Other
 * @version ${project.version}
 */
@RosettaDataType(value="OrganizationType", builder=OrganizationType.OrganizationTypeBuilderImpl.class, version="${project.version}")
public interface OrganizationType extends RosettaModelObject {

	OrganizationTypeMeta metaData = new OrganizationTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getOrganizationTypeScheme();

	/*********************** Build Methods  ***********************/
	OrganizationType build();
	
	OrganizationType.OrganizationTypeBuilder toBuilder();
	
	static OrganizationType.OrganizationTypeBuilder builder() {
		return new OrganizationType.OrganizationTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganizationType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OrganizationType> getType() {
		return OrganizationType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("organizationTypeScheme"), String.class, getOrganizationTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganizationTypeBuilder extends OrganizationType, RosettaModelObjectBuilder {
		OrganizationType.OrganizationTypeBuilder setValue(String value);
		OrganizationType.OrganizationTypeBuilder setOrganizationTypeScheme(String organizationTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("organizationTypeScheme"), String.class, getOrganizationTypeScheme(), this);
		}
		

		OrganizationType.OrganizationTypeBuilder prune();
	}

	/*********************** Immutable Implementation of OrganizationType  ***********************/
	class OrganizationTypeImpl implements OrganizationType {
		private final String value;
		private final String organizationTypeScheme;
		
		protected OrganizationTypeImpl(OrganizationType.OrganizationTypeBuilder builder) {
			this.value = builder.getValue();
			this.organizationTypeScheme = builder.getOrganizationTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("organizationTypeScheme")
		public String getOrganizationTypeScheme() {
			return organizationTypeScheme;
		}
		
		@Override
		public OrganizationType build() {
			return this;
		}
		
		@Override
		public OrganizationType.OrganizationTypeBuilder toBuilder() {
			OrganizationType.OrganizationTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganizationType.OrganizationTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getOrganizationTypeScheme()).ifPresent(builder::setOrganizationTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganizationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(organizationTypeScheme, _that.getOrganizationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (organizationTypeScheme != null ? organizationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganizationType {" +
				"value=" + this.value + ", " +
				"organizationTypeScheme=" + this.organizationTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganizationType  ***********************/
	class OrganizationTypeBuilderImpl implements OrganizationType.OrganizationTypeBuilder {
	
		protected String value;
		protected String organizationTypeScheme;
	
		public OrganizationTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("organizationTypeScheme")
		public String getOrganizationTypeScheme() {
			return organizationTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public OrganizationType.OrganizationTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("organizationTypeScheme")
		public OrganizationType.OrganizationTypeBuilder setOrganizationTypeScheme(String organizationTypeScheme) {
			this.organizationTypeScheme = organizationTypeScheme==null?null:organizationTypeScheme;
			return this;
		}
		
		@Override
		public OrganizationType build() {
			return new OrganizationType.OrganizationTypeImpl(this);
		}
		
		@Override
		public OrganizationType.OrganizationTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganizationType.OrganizationTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getOrganizationTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganizationType.OrganizationTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganizationType.OrganizationTypeBuilder o = (OrganizationType.OrganizationTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getOrganizationTypeScheme(), o.getOrganizationTypeScheme(), this::setOrganizationTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganizationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(organizationTypeScheme, _that.getOrganizationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (organizationTypeScheme != null ? organizationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganizationTypeBuilder {" +
				"value=" + this.value + ", " +
				"organizationTypeScheme=" + this.organizationTypeScheme +
			'}';
		}
	}
}
