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
import fpml.confirmation.TradeNotionalChangeModelSequence2;
import fpml.confirmation.TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder;
import fpml.confirmation.TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2BuilderImpl;
import fpml.confirmation.TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Impl;
import fpml.confirmation.meta.TradeNotionalChangeModelSequence2Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradeNotionalChangeModelSequence2", builder=TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradeNotionalChangeModelSequence2 extends RosettaModelObject {

	TradeNotionalChangeModelSequence2Meta metaData = new TradeNotionalChangeModelSequence2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the fixed amount by which the Number of Units changes
	 */
	BigDecimal getChangeInNumberOfUnits();
	/**
	 * Specifies the Number of Units
	 */
	BigDecimal getOutstandingNumberOfUnits();

	/*********************** Build Methods  ***********************/
	TradeNotionalChangeModelSequence2 build();
	
	TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder toBuilder();
	
	static TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder builder() {
		return new TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNotionalChangeModelSequence2> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeNotionalChangeModelSequence2> getType() {
		return TradeNotionalChangeModelSequence2.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("changeInNumberOfUnits"), BigDecimal.class, getChangeInNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNotionalChangeModelSequence2Builder extends TradeNotionalChangeModelSequence2, RosettaModelObjectBuilder {
		TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder setChangeInNumberOfUnits(BigDecimal changeInNumberOfUnits);
		TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("changeInNumberOfUnits"), BigDecimal.class, getChangeInNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
		}
		

		TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder prune();
	}

	/*********************** Immutable Implementation of TradeNotionalChangeModelSequence2  ***********************/
	class TradeNotionalChangeModelSequence2Impl implements TradeNotionalChangeModelSequence2 {
		private final BigDecimal changeInNumberOfUnits;
		private final BigDecimal outstandingNumberOfUnits;
		
		protected TradeNotionalChangeModelSequence2Impl(TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder builder) {
			this.changeInNumberOfUnits = builder.getChangeInNumberOfUnits();
			this.outstandingNumberOfUnits = builder.getOutstandingNumberOfUnits();
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		public BigDecimal getChangeInNumberOfUnits() {
			return changeInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		public TradeNotionalChangeModelSequence2 build() {
			return this;
		}
		
		@Override
		public TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder toBuilder() {
			TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder builder) {
			ofNullable(getChangeInNumberOfUnits()).ifPresent(builder::setChangeInNumberOfUnits);
			ofNullable(getOutstandingNumberOfUnits()).ifPresent(builder::setOutstandingNumberOfUnits);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNotionalChangeModelSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(changeInNumberOfUnits, _that.getChangeInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInNumberOfUnits != null ? changeInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeModelSequence2 {" +
				"changeInNumberOfUnits=" + this.changeInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeNotionalChangeModelSequence2  ***********************/
	class TradeNotionalChangeModelSequence2BuilderImpl implements TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder {
	
		protected BigDecimal changeInNumberOfUnits;
		protected BigDecimal outstandingNumberOfUnits;
	
		public TradeNotionalChangeModelSequence2BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		public BigDecimal getChangeInNumberOfUnits() {
			return changeInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		public TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder setChangeInNumberOfUnits(BigDecimal changeInNumberOfUnits) {
			this.changeInNumberOfUnits = changeInNumberOfUnits==null?null:changeInNumberOfUnits;
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits) {
			this.outstandingNumberOfUnits = outstandingNumberOfUnits==null?null:outstandingNumberOfUnits;
			return this;
		}
		
		@Override
		public TradeNotionalChangeModelSequence2 build() {
			return new TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Impl(this);
		}
		
		@Override
		public TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getChangeInNumberOfUnits()!=null) return true;
			if (getOutstandingNumberOfUnits()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder o = (TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder) other;
			
			
			merger.mergeBasic(getChangeInNumberOfUnits(), o.getChangeInNumberOfUnits(), this::setChangeInNumberOfUnits);
			merger.mergeBasic(getOutstandingNumberOfUnits(), o.getOutstandingNumberOfUnits(), this::setOutstandingNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNotionalChangeModelSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(changeInNumberOfUnits, _that.getChangeInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInNumberOfUnits != null ? changeInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeModelSequence2Builder {" +
				"changeInNumberOfUnits=" + this.changeInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}
}
