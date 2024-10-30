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
import fpml.confirmation.CreditLimitUtilizationPosition;
import fpml.confirmation.CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder;
import fpml.confirmation.CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilderImpl;
import fpml.confirmation.CreditLimitUtilizationPosition.CreditLimitUtilizationPositionImpl;
import fpml.confirmation.CreditLimitUtilizationPositionSequence;
import fpml.confirmation.meta.CreditLimitUtilizationPositionMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CreditLimitUtilizationPosition", builder=CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CreditLimitUtilizationPosition extends RosettaModelObject {

	CreditLimitUtilizationPositionMeta metaData = new CreditLimitUtilizationPositionMeta();

	/*********************** Getter Methods  ***********************/
	CreditLimitUtilizationPositionSequence getCreditLimitUtilizationPositionSequence();
	/**
	 * Global credit limit utilization amount, agnostic of long/short position direction.
	 */
	BigDecimal getGlobal();

	/*********************** Build Methods  ***********************/
	CreditLimitUtilizationPosition build();
	
	CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder toBuilder();
	
	static CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder builder() {
		return new CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimitUtilizationPosition> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditLimitUtilizationPosition> getType() {
		return CreditLimitUtilizationPosition.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("creditLimitUtilizationPositionSequence"), processor, CreditLimitUtilizationPositionSequence.class, getCreditLimitUtilizationPositionSequence());
		processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitUtilizationPositionBuilder extends CreditLimitUtilizationPosition, RosettaModelObjectBuilder {
		CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder getOrCreateCreditLimitUtilizationPositionSequence();
		CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder getCreditLimitUtilizationPositionSequence();
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setCreditLimitUtilizationPositionSequence(CreditLimitUtilizationPositionSequence creditLimitUtilizationPositionSequence);
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setGlobal(BigDecimal global);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("creditLimitUtilizationPositionSequence"), processor, CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder.class, getCreditLimitUtilizationPositionSequence());
			processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
		}
		

		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimitUtilizationPosition  ***********************/
	class CreditLimitUtilizationPositionImpl implements CreditLimitUtilizationPosition {
		private final CreditLimitUtilizationPositionSequence creditLimitUtilizationPositionSequence;
		private final BigDecimal global;
		
		protected CreditLimitUtilizationPositionImpl(CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder builder) {
			this.creditLimitUtilizationPositionSequence = ofNullable(builder.getCreditLimitUtilizationPositionSequence()).map(f->f.build()).orElse(null);
			this.global = builder.getGlobal();
		}
		
		@Override
		@RosettaAttribute("creditLimitUtilizationPositionSequence")
		public CreditLimitUtilizationPositionSequence getCreditLimitUtilizationPositionSequence() {
			return creditLimitUtilizationPositionSequence;
		}
		
		@Override
		@RosettaAttribute("global")
		public BigDecimal getGlobal() {
			return global;
		}
		
		@Override
		public CreditLimitUtilizationPosition build() {
			return this;
		}
		
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder toBuilder() {
			CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder builder) {
			ofNullable(getCreditLimitUtilizationPositionSequence()).ifPresent(builder::setCreditLimitUtilizationPositionSequence);
			ofNullable(getGlobal()).ifPresent(builder::setGlobal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilizationPosition _that = getType().cast(o);
		
			if (!Objects.equals(creditLimitUtilizationPositionSequence, _that.getCreditLimitUtilizationPositionSequence())) return false;
			if (!Objects.equals(global, _that.getGlobal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditLimitUtilizationPositionSequence != null ? creditLimitUtilizationPositionSequence.hashCode() : 0);
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilizationPosition {" +
				"creditLimitUtilizationPositionSequence=" + this.creditLimitUtilizationPositionSequence + ", " +
				"global=" + this.global +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditLimitUtilizationPosition  ***********************/
	class CreditLimitUtilizationPositionBuilderImpl implements CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder {
	
		protected CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder creditLimitUtilizationPositionSequence;
		protected BigDecimal global;
	
		public CreditLimitUtilizationPositionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("creditLimitUtilizationPositionSequence")
		public CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder getCreditLimitUtilizationPositionSequence() {
			return creditLimitUtilizationPositionSequence;
		}
		
		@Override
		public CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder getOrCreateCreditLimitUtilizationPositionSequence() {
			CreditLimitUtilizationPositionSequence.CreditLimitUtilizationPositionSequenceBuilder result;
			if (creditLimitUtilizationPositionSequence!=null) {
				result = creditLimitUtilizationPositionSequence;
			}
			else {
				result = creditLimitUtilizationPositionSequence = CreditLimitUtilizationPositionSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("global")
		public BigDecimal getGlobal() {
			return global;
		}
		
		@Override
		@RosettaAttribute("creditLimitUtilizationPositionSequence")
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setCreditLimitUtilizationPositionSequence(CreditLimitUtilizationPositionSequence creditLimitUtilizationPositionSequence) {
			this.creditLimitUtilizationPositionSequence = creditLimitUtilizationPositionSequence==null?null:creditLimitUtilizationPositionSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("global")
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder setGlobal(BigDecimal global) {
			this.global = global==null?null:global;
			return this;
		}
		
		@Override
		public CreditLimitUtilizationPosition build() {
			return new CreditLimitUtilizationPosition.CreditLimitUtilizationPositionImpl(this);
		}
		
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder prune() {
			if (creditLimitUtilizationPositionSequence!=null && !creditLimitUtilizationPositionSequence.prune().hasData()) creditLimitUtilizationPositionSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditLimitUtilizationPositionSequence()!=null && getCreditLimitUtilizationPositionSequence().hasData()) return true;
			if (getGlobal()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder o = (CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder) other;
			
			merger.mergeRosetta(getCreditLimitUtilizationPositionSequence(), o.getCreditLimitUtilizationPositionSequence(), this::setCreditLimitUtilizationPositionSequence);
			
			merger.mergeBasic(getGlobal(), o.getGlobal(), this::setGlobal);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilizationPosition _that = getType().cast(o);
		
			if (!Objects.equals(creditLimitUtilizationPositionSequence, _that.getCreditLimitUtilizationPositionSequence())) return false;
			if (!Objects.equals(global, _that.getGlobal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditLimitUtilizationPositionSequence != null ? creditLimitUtilizationPositionSequence.hashCode() : 0);
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilizationPositionBuilder {" +
				"creditLimitUtilizationPositionSequence=" + this.creditLimitUtilizationPositionSequence + ", " +
				"global=" + this.global +
			'}';
		}
	}
}
