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
import fpml.confirmation.PartyRoleType;
import fpml.confirmation.PartyRoleType.PartyRoleTypeBuilder;
import fpml.confirmation.PartyRoleType.PartyRoleTypeBuilderImpl;
import fpml.confirmation.PartyRoleType.PartyRoleTypeImpl;
import fpml.confirmation.meta.PartyRoleTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type refining the role a role played by a party in one or more transactions. Examples include &quot;AllPositions&quot; and &quot;SomePositions&quot; for Guarantor. This can be extended to provide custom types.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyRoleType", builder=PartyRoleType.PartyRoleTypeBuilderImpl.class, version="${project.version}")
public interface PartyRoleType extends RosettaModelObject {

	PartyRoleTypeMeta metaData = new PartyRoleTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPartyRoleTypeScheme();

	/*********************** Build Methods  ***********************/
	PartyRoleType build();
	
	PartyRoleType.PartyRoleTypeBuilder toBuilder();
	
	static PartyRoleType.PartyRoleTypeBuilder builder() {
		return new PartyRoleType.PartyRoleTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyRoleType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyRoleType> getType() {
		return PartyRoleType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyRoleTypeScheme"), String.class, getPartyRoleTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyRoleTypeBuilder extends PartyRoleType, RosettaModelObjectBuilder {
		PartyRoleType.PartyRoleTypeBuilder setValue(String value);
		PartyRoleType.PartyRoleTypeBuilder setPartyRoleTypeScheme(String partyRoleTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyRoleTypeScheme"), String.class, getPartyRoleTypeScheme(), this);
		}
		

		PartyRoleType.PartyRoleTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PartyRoleType  ***********************/
	class PartyRoleTypeImpl implements PartyRoleType {
		private final String value;
		private final String partyRoleTypeScheme;
		
		protected PartyRoleTypeImpl(PartyRoleType.PartyRoleTypeBuilder builder) {
			this.value = builder.getValue();
			this.partyRoleTypeScheme = builder.getPartyRoleTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyRoleTypeScheme")
		public String getPartyRoleTypeScheme() {
			return partyRoleTypeScheme;
		}
		
		@Override
		public PartyRoleType build() {
			return this;
		}
		
		@Override
		public PartyRoleType.PartyRoleTypeBuilder toBuilder() {
			PartyRoleType.PartyRoleTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyRoleType.PartyRoleTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyRoleTypeScheme()).ifPresent(builder::setPartyRoleTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRoleType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyRoleTypeScheme, _that.getPartyRoleTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyRoleTypeScheme != null ? partyRoleTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRoleType {" +
				"value=" + this.value + ", " +
				"partyRoleTypeScheme=" + this.partyRoleTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyRoleType  ***********************/
	class PartyRoleTypeBuilderImpl implements PartyRoleType.PartyRoleTypeBuilder {
	
		protected String value;
		protected String partyRoleTypeScheme;
	
		public PartyRoleTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyRoleTypeScheme")
		public String getPartyRoleTypeScheme() {
			return partyRoleTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PartyRoleType.PartyRoleTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("partyRoleTypeScheme")
		public PartyRoleType.PartyRoleTypeBuilder setPartyRoleTypeScheme(String partyRoleTypeScheme) {
			this.partyRoleTypeScheme = partyRoleTypeScheme==null?null:partyRoleTypeScheme;
			return this;
		}
		
		@Override
		public PartyRoleType build() {
			return new PartyRoleType.PartyRoleTypeImpl(this);
		}
		
		@Override
		public PartyRoleType.PartyRoleTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRoleType.PartyRoleTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyRoleTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyRoleType.PartyRoleTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyRoleType.PartyRoleTypeBuilder o = (PartyRoleType.PartyRoleTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyRoleTypeScheme(), o.getPartyRoleTypeScheme(), this::setPartyRoleTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyRoleType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyRoleTypeScheme, _that.getPartyRoleTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyRoleTypeScheme != null ? partyRoleTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyRoleTypeBuilder {" +
				"value=" + this.value + ", " +
				"partyRoleTypeScheme=" + this.partyRoleTypeScheme +
			'}';
		}
	}
}
