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
import fpml.confirmation.TelephoneNumber;
import fpml.confirmation.TelephoneNumber.TelephoneNumberBuilder;
import fpml.confirmation.TelephoneNumber.TelephoneNumberBuilderImpl;
import fpml.confirmation.TelephoneNumber.TelephoneNumberImpl;
import fpml.confirmation.TelephoneTypeEnum;
import fpml.confirmation.meta.TelephoneNumberMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that represents a telephonic contact.
 * @version ${project.version}
 */
@RosettaDataType(value="TelephoneNumber", builder=TelephoneNumber.TelephoneNumberBuilderImpl.class, version="${project.version}")
public interface TelephoneNumber extends RosettaModelObject {

	TelephoneNumberMeta metaData = new TelephoneNumberMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of telephone number (work, personal, mobile).
	 */
	TelephoneTypeEnum getType();
	/**
	 * A telephonic contact.
	 */
	String getNumber();

	/*********************** Build Methods  ***********************/
	TelephoneNumber build();
	
	TelephoneNumber.TelephoneNumberBuilder toBuilder();
	
	static TelephoneNumber.TelephoneNumberBuilder builder() {
		return new TelephoneNumber.TelephoneNumberBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TelephoneNumber> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TelephoneNumber> getType() {
		return TelephoneNumber.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("type"), TelephoneTypeEnum.class, getType(), this);
		processor.processBasic(path.newSubPath("number"), String.class, getNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TelephoneNumberBuilder extends TelephoneNumber, RosettaModelObjectBuilder {
		TelephoneNumber.TelephoneNumberBuilder setType(TelephoneTypeEnum type);
		TelephoneNumber.TelephoneNumberBuilder setNumber(String number);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("type"), TelephoneTypeEnum.class, getType(), this);
			processor.processBasic(path.newSubPath("number"), String.class, getNumber(), this);
		}
		

		TelephoneNumber.TelephoneNumberBuilder prune();
	}

	/*********************** Immutable Implementation of TelephoneNumber  ***********************/
	class TelephoneNumberImpl implements TelephoneNumber {
		private final TelephoneTypeEnum type;
		private final String number;
		
		protected TelephoneNumberImpl(TelephoneNumber.TelephoneNumberBuilder builder) {
			this.type = builder.getType();
			this.number = builder.getNumber();
		}
		
		@Override
		@RosettaAttribute("type")
		public TelephoneTypeEnum getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("number")
		public String getNumber() {
			return number;
		}
		
		@Override
		public TelephoneNumber build() {
			return this;
		}
		
		@Override
		public TelephoneNumber.TelephoneNumberBuilder toBuilder() {
			TelephoneNumber.TelephoneNumberBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TelephoneNumber.TelephoneNumberBuilder builder) {
			ofNullable(getType()).ifPresent(builder::setType);
			ofNullable(getNumber()).ifPresent(builder::setNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TelephoneNumber _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(number, _that.getNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TelephoneNumber {" +
				"type=" + this.type + ", " +
				"number=" + this.number +
			'}';
		}
	}

	/*********************** Builder Implementation of TelephoneNumber  ***********************/
	class TelephoneNumberBuilderImpl implements TelephoneNumber.TelephoneNumberBuilder {
	
		protected TelephoneTypeEnum type;
		protected String number;
	
		public TelephoneNumberBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public TelephoneTypeEnum getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("number")
		public String getNumber() {
			return number;
		}
		
		@Override
		@RosettaAttribute("type")
		public TelephoneNumber.TelephoneNumberBuilder setType(TelephoneTypeEnum type) {
			this.type = type==null?null:type;
			return this;
		}
		@Override
		@RosettaAttribute("number")
		public TelephoneNumber.TelephoneNumberBuilder setNumber(String number) {
			this.number = number==null?null:number;
			return this;
		}
		
		@Override
		public TelephoneNumber build() {
			return new TelephoneNumber.TelephoneNumberImpl(this);
		}
		
		@Override
		public TelephoneNumber.TelephoneNumberBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getType()!=null) return true;
			if (getNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TelephoneNumber.TelephoneNumberBuilder o = (TelephoneNumber.TelephoneNumberBuilder) other;
			
			
			merger.mergeBasic(getType(), o.getType(), this::setType);
			merger.mergeBasic(getNumber(), o.getNumber(), this::setNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TelephoneNumber _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(number, _that.getNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TelephoneNumberBuilder {" +
				"type=" + this.type + ", " +
				"number=" + this.number +
			'}';
		}
	}
}
