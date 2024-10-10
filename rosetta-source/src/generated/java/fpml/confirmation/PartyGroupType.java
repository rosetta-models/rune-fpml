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
import fpml.confirmation.PartyGroupType;
import fpml.confirmation.PartyGroupType.PartyGroupTypeBuilder;
import fpml.confirmation.PartyGroupType.PartyGroupTypeBuilderImpl;
import fpml.confirmation.PartyGroupType.PartyGroupTypeImpl;
import fpml.confirmation.meta.PartyGroupTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for party group classification.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyGroupType", builder=PartyGroupType.PartyGroupTypeBuilderImpl.class, version="${project.version}")
public interface PartyGroupType extends RosettaModelObject {

	PartyGroupTypeMeta metaData = new PartyGroupTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPartyGroupTypeScheme();

	/*********************** Build Methods  ***********************/
	PartyGroupType build();
	
	PartyGroupType.PartyGroupTypeBuilder toBuilder();
	
	static PartyGroupType.PartyGroupTypeBuilder builder() {
		return new PartyGroupType.PartyGroupTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyGroupType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyGroupType> getType() {
		return PartyGroupType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyGroupTypeScheme"), String.class, getPartyGroupTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyGroupTypeBuilder extends PartyGroupType, RosettaModelObjectBuilder {
		PartyGroupType.PartyGroupTypeBuilder setValue(String value);
		PartyGroupType.PartyGroupTypeBuilder setPartyGroupTypeScheme(String partyGroupTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyGroupTypeScheme"), String.class, getPartyGroupTypeScheme(), this);
		}
		

		PartyGroupType.PartyGroupTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PartyGroupType  ***********************/
	class PartyGroupTypeImpl implements PartyGroupType {
		private final String value;
		private final String partyGroupTypeScheme;
		
		protected PartyGroupTypeImpl(PartyGroupType.PartyGroupTypeBuilder builder) {
			this.value = builder.getValue();
			this.partyGroupTypeScheme = builder.getPartyGroupTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyGroupTypeScheme")
		public String getPartyGroupTypeScheme() {
			return partyGroupTypeScheme;
		}
		
		@Override
		public PartyGroupType build() {
			return this;
		}
		
		@Override
		public PartyGroupType.PartyGroupTypeBuilder toBuilder() {
			PartyGroupType.PartyGroupTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyGroupType.PartyGroupTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyGroupTypeScheme()).ifPresent(builder::setPartyGroupTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyGroupType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyGroupTypeScheme, _that.getPartyGroupTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyGroupTypeScheme != null ? partyGroupTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyGroupType {" +
				"value=" + this.value + ", " +
				"partyGroupTypeScheme=" + this.partyGroupTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyGroupType  ***********************/
	class PartyGroupTypeBuilderImpl implements PartyGroupType.PartyGroupTypeBuilder {
	
		protected String value;
		protected String partyGroupTypeScheme;
	
		public PartyGroupTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyGroupTypeScheme")
		public String getPartyGroupTypeScheme() {
			return partyGroupTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PartyGroupType.PartyGroupTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("partyGroupTypeScheme")
		public PartyGroupType.PartyGroupTypeBuilder setPartyGroupTypeScheme(String partyGroupTypeScheme) {
			this.partyGroupTypeScheme = partyGroupTypeScheme==null?null:partyGroupTypeScheme;
			return this;
		}
		
		@Override
		public PartyGroupType build() {
			return new PartyGroupType.PartyGroupTypeImpl(this);
		}
		
		@Override
		public PartyGroupType.PartyGroupTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyGroupType.PartyGroupTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyGroupTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyGroupType.PartyGroupTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyGroupType.PartyGroupTypeBuilder o = (PartyGroupType.PartyGroupTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyGroupTypeScheme(), o.getPartyGroupTypeScheme(), this::setPartyGroupTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyGroupType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyGroupTypeScheme, _that.getPartyGroupTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyGroupTypeScheme != null ? partyGroupTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyGroupTypeBuilder {" +
				"value=" + this.value + ", " +
				"partyGroupTypeScheme=" + this.partyGroupTypeScheme +
			'}';
		}
	}
}
