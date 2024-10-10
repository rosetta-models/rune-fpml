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
import fpml.confirmation.CreditLimitUtilizationPositionSequence;
import fpml.confirmation.CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder;
import fpml.confirmation.CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilderImpl;
import fpml.confirmation.CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceImpl;
import fpml.confirmation.meta.CreditLimitUtilizationPositionSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CreditLimitUtilizationPositionSequence", builder=CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilderImpl.class, version="${project.version}")
public interface CreditLimitUtilizationPositionSequence extends RosettaModelObject {

	CreditLimitUtilizationPositionSequenceMeta metaData = new CreditLimitUtilizationPositionSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Credit limit utilization attributable to short positions.
	 */
	BigDecimal getShort();
	/**
	 * Credit limit utilization attributable to long positions.
	 */
	BigDecimal getLong();
	/**
	 * Global credit limit utilization amount, agnostic of long/short position direction.
	 */
	BigDecimal getGlobal();

	/*********************** Build Methods  ***********************/
	CreditLimitUtilizationPositionSequence build();
	
	CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder toBuilder();
	
	static CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder builder() {
		return new CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimitUtilizationPositionSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditLimitUtilizationPositionSequence> getType() {
		return CreditLimitUtilizationPositionSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("short"), BigDecimal.class, getShort(), this);
		processor.processBasic(path.newSubPath("long"), BigDecimal.class, getLong(), this);
		processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitUtilizationPositionSequenceBuilder extends CreditLimitUtilizationPositionSequence, RosettaModelObjectBuilder {
		CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder setShort(BigDecimal _short);
		CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder setLong(BigDecimal _long);
		CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder setGlobal(BigDecimal global);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("short"), BigDecimal.class, getShort(), this);
			processor.processBasic(path.newSubPath("long"), BigDecimal.class, getLong(), this);
			processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
		}
		

		CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimitUtilizationPositionSequence  ***********************/
	class CreditLimitUtilizationPositionSequenceImpl implements CreditLimitUtilizationPositionSequence {
		private final BigDecimal _short;
		private final BigDecimal _long;
		private final BigDecimal global;
		
		protected CreditLimitUtilizationPositionSequenceImpl(CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder builder) {
			this._short = builder.getShort();
			this._long = builder.getLong();
			this.global = builder.getGlobal();
		}
		
		@Override
		@RosettaAttribute("short")
		public BigDecimal getShort() {
			return _short;
		}
		
		@Override
		@RosettaAttribute("long")
		public BigDecimal getLong() {
			return _long;
		}
		
		@Override
		@RosettaAttribute("global")
		public BigDecimal getGlobal() {
			return global;
		}
		
		@Override
		public CreditLimitUtilizationPositionSequence build() {
			return this;
		}
		
		@Override
		public CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder toBuilder() {
			CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder builder) {
			ofNullable(getShort()).ifPresent(builder::setShort);
			ofNullable(getLong()).ifPresent(builder::setLong);
			ofNullable(getGlobal()).ifPresent(builder::setGlobal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilizationPositionSequence _that = getType().cast(o);
		
			if (!Objects.equals(_short, _that.getShort())) return false;
			if (!Objects.equals(_long, _that.getLong())) return false;
			if (!Objects.equals(global, _that.getGlobal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_short != null ? _short.hashCode() : 0);
			_result = 31 * _result + (_long != null ? _long.hashCode() : 0);
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilizationPositionSequence {" +
				"short=" + this._short + ", " +
				"long=" + this._long + ", " +
				"global=" + this.global +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditLimitUtilizationPositionSequence  ***********************/
	class CreditLimitUtilizationPositionSequenceBuilderImpl implements CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder {
	
		protected BigDecimal _short;
		protected BigDecimal _long;
		protected BigDecimal global;
	
		public CreditLimitUtilizationPositionSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("short")
		public BigDecimal getShort() {
			return _short;
		}
		
		@Override
		@RosettaAttribute("long")
		public BigDecimal getLong() {
			return _long;
		}
		
		@Override
		@RosettaAttribute("global")
		public BigDecimal getGlobal() {
			return global;
		}
		
		@Override
		@RosettaAttribute("short")
		public CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder setShort(BigDecimal _short) {
			this._short = _short==null?null:_short;
			return this;
		}
		@Override
		@RosettaAttribute("long")
		public CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder setLong(BigDecimal _long) {
			this._long = _long==null?null:_long;
			return this;
		}
		@Override
		@RosettaAttribute("global")
		public CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder setGlobal(BigDecimal global) {
			this.global = global==null?null:global;
			return this;
		}
		
		@Override
		public CreditLimitUtilizationPositionSequence build() {
			return new CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceImpl(this);
		}
		
		@Override
		public CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getShort()!=null) return true;
			if (getLong()!=null) return true;
			if (getGlobal()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder o = (CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder) other;
			
			
			merger.mergeBasic(getShort(), o.getShort(), this::setShort);
			merger.mergeBasic(getLong(), o.getLong(), this::setLong);
			merger.mergeBasic(getGlobal(), o.getGlobal(), this::setGlobal);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilizationPositionSequence _that = getType().cast(o);
		
			if (!Objects.equals(_short, _that.getShort())) return false;
			if (!Objects.equals(_long, _that.getLong())) return false;
			if (!Objects.equals(global, _that.getGlobal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_short != null ? _short.hashCode() : 0);
			_result = 31 * _result + (_long != null ? _long.hashCode() : 0);
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilizationPositionSequenceBuilder {" +
				"short=" + this._short + ", " +
				"long=" + this._long + ", " +
				"global=" + this.global +
			'}';
		}
	}
}
