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
import fpml.confirmation.PartyProfileId;
import fpml.confirmation.PartyProfileId.PartyProfileIdBuilder;
import fpml.confirmation.PartyProfileId.PartyProfileIdBuilderImpl;
import fpml.confirmation.PartyProfileId.PartyProfileIdImpl;
import fpml.confirmation.meta.PartyProfileIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines a party profile identifier based on a qualifying scheme.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PartyProfileId", builder=PartyProfileId.PartyProfileIdBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PartyProfileId extends RosettaModelObject {

	PartyProfileIdMeta metaData = new PartyProfileIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPartyProfileIdScheme();

	/*********************** Build Methods  ***********************/
	PartyProfileId build();
	
	PartyProfileId.PartyProfileIdBuilder toBuilder();
	
	static PartyProfileId.PartyProfileIdBuilder builder() {
		return new PartyProfileId.PartyProfileIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyProfileId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyProfileId> getType() {
		return PartyProfileId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyProfileIdScheme"), String.class, getPartyProfileIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyProfileIdBuilder extends PartyProfileId, RosettaModelObjectBuilder {
		PartyProfileId.PartyProfileIdBuilder setValue(String value);
		PartyProfileId.PartyProfileIdBuilder setPartyProfileIdScheme(String partyProfileIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyProfileIdScheme"), String.class, getPartyProfileIdScheme(), this);
		}
		

		PartyProfileId.PartyProfileIdBuilder prune();
	}

	/*********************** Immutable Implementation of PartyProfileId  ***********************/
	class PartyProfileIdImpl implements PartyProfileId {
		private final String value;
		private final String partyProfileIdScheme;
		
		protected PartyProfileIdImpl(PartyProfileId.PartyProfileIdBuilder builder) {
			this.value = builder.getValue();
			this.partyProfileIdScheme = builder.getPartyProfileIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyProfileIdScheme")
		public String getPartyProfileIdScheme() {
			return partyProfileIdScheme;
		}
		
		@Override
		public PartyProfileId build() {
			return this;
		}
		
		@Override
		public PartyProfileId.PartyProfileIdBuilder toBuilder() {
			PartyProfileId.PartyProfileIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyProfileId.PartyProfileIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyProfileIdScheme()).ifPresent(builder::setPartyProfileIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyProfileIdScheme, _that.getPartyProfileIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyProfileIdScheme != null ? partyProfileIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileId {" +
				"value=" + this.value + ", " +
				"partyProfileIdScheme=" + this.partyProfileIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyProfileId  ***********************/
	class PartyProfileIdBuilderImpl implements PartyProfileId.PartyProfileIdBuilder {
	
		protected String value;
		protected String partyProfileIdScheme;
	
		public PartyProfileIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyProfileIdScheme")
		public String getPartyProfileIdScheme() {
			return partyProfileIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PartyProfileId.PartyProfileIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("partyProfileIdScheme")
		public PartyProfileId.PartyProfileIdBuilder setPartyProfileIdScheme(String partyProfileIdScheme) {
			this.partyProfileIdScheme = partyProfileIdScheme==null?null:partyProfileIdScheme;
			return this;
		}
		
		@Override
		public PartyProfileId build() {
			return new PartyProfileId.PartyProfileIdImpl(this);
		}
		
		@Override
		public PartyProfileId.PartyProfileIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileId.PartyProfileIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyProfileIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileId.PartyProfileIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyProfileId.PartyProfileIdBuilder o = (PartyProfileId.PartyProfileIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyProfileIdScheme(), o.getPartyProfileIdScheme(), this::setPartyProfileIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyProfileIdScheme, _that.getPartyProfileIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyProfileIdScheme != null ? partyProfileIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileIdBuilder {" +
				"value=" + this.value + ", " +
				"partyProfileIdScheme=" + this.partyProfileIdScheme +
			'}';
		}
	}
}
