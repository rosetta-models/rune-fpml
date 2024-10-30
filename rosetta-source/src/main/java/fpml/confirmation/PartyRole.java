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
import fpml.confirmation.PartyRole;
import fpml.confirmation.PartyRole.PartyRoleBuilder;
import fpml.confirmation.PartyRole.PartyRoleBuilderImpl;
import fpml.confirmation.PartyRole.PartyRoleImpl;
import fpml.confirmation.meta.PartyRoleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing a role played by a party in one or more transactions. Examples include roles such as guarantor, custodian, confirmation service provider, etc. This can be extended to provide custom roles.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PartyRole", builder=PartyRole.PartyRoleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PartyRole extends RosettaModelObject {

	PartyRoleMeta metaData = new PartyRoleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPartyRoleScheme();

	/*********************** Build Methods  ***********************/
	PartyRole build();
	
	PartyRole.PartyRoleBuilder toBuilder();
	
	static PartyRole.PartyRoleBuilder builder() {
		return new PartyRole.PartyRoleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyRole> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyRole> getType() {
		return PartyRole.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyRoleScheme"), String.class, getPartyRoleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyRoleBuilder extends PartyRole, RosettaModelObjectBuilder {
		PartyRole.PartyRoleBuilder setValue(String value);
		PartyRole.PartyRoleBuilder setPartyRoleScheme(String partyRoleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyRoleScheme"), String.class, getPartyRoleScheme(), this);
		}
		

		PartyRole.PartyRoleBuilder prune();
	}

	/*********************** Immutable Implementation of PartyRole  ***********************/
	class PartyRoleImpl implements PartyRole {
		private final String value;
		private final String partyRoleScheme;
		
		protected PartyRoleImpl(PartyRole.PartyRoleBuilder builder) {
			this.value = builder.getValue();
			this.partyRoleScheme = builder.getPartyRoleScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyRoleScheme")
		public String getPartyRoleScheme() {
			return partyRoleScheme;
		}
		
		@Override
		public PartyRole build() {
			return this;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder toBuilder() {
			PartyRole.PartyRoleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyRole.PartyRoleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyRoleScheme()).ifPresent(builder::setPartyRoleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyRoleScheme, _that.getPartyRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyRoleScheme != null ? partyRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRole {" +
				"value=" + this.value + ", " +
				"partyRoleScheme=" + this.partyRoleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyRole  ***********************/
	class PartyRoleBuilderImpl implements PartyRole.PartyRoleBuilder {
	
		protected String value;
		protected String partyRoleScheme;
	
		public PartyRoleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyRoleScheme")
		public String getPartyRoleScheme() {
			return partyRoleScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PartyRole.PartyRoleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("partyRoleScheme")
		public PartyRole.PartyRoleBuilder setPartyRoleScheme(String partyRoleScheme) {
			this.partyRoleScheme = partyRoleScheme==null?null:partyRoleScheme;
			return this;
		}
		
		@Override
		public PartyRole build() {
			return new PartyRole.PartyRoleImpl(this);
		}
		
		@Override
		public PartyRole.PartyRoleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRole.PartyRoleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyRoleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRole.PartyRoleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyRole.PartyRoleBuilder o = (PartyRole.PartyRoleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyRoleScheme(), o.getPartyRoleScheme(), this::setPartyRoleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyRoleScheme, _that.getPartyRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyRoleScheme != null ? partyRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRoleBuilder {" +
				"value=" + this.value + ", " +
				"partyRoleScheme=" + this.partyRoleScheme +
			'}';
		}
	}
}
