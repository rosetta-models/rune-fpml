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
import fpml.confirmation.SettlementPeriodLeverage;
import fpml.confirmation.SettlementPeriodLeverage.SettlementPeriodLeverageBuilder;
import fpml.confirmation.SettlementPeriodLeverage.SettlementPeriodLeverageBuilderImpl;
import fpml.confirmation.SettlementPeriodLeverage.SettlementPeriodLeverageImpl;
import fpml.confirmation.SettlementPeriodLeverageSequence;
import fpml.confirmation.meta.SettlementPeriodLeverageMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementPeriodLeverage", builder=SettlementPeriodLeverage.SettlementPeriodLeverageBuilderImpl.class, version="${project.version}")
public interface SettlementPeriodLeverage extends RosettaModelObject {

	SettlementPeriodLeverageMeta metaData = new SettlementPeriodLeverageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Leverage expressed as ratio.
	 */
	BigDecimal getRatio();
	SettlementPeriodLeverageSequence getSettlementPeriodLeverageSequence();

	/*********************** Build Methods  ***********************/
	SettlementPeriodLeverage build();
	
	SettlementPeriodLeverage.SettlementPeriodLeverageBuilder toBuilder();
	
	static SettlementPeriodLeverage.SettlementPeriodLeverageBuilder builder() {
		return new SettlementPeriodLeverage.SettlementPeriodLeverageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodLeverage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPeriodLeverage> getType() {
		return SettlementPeriodLeverage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ratio"), BigDecimal.class, getRatio(), this);
		processRosetta(path.newSubPath("settlementPeriodLeverageSequence"), processor, SettlementPeriodLeverageSequence.class, getSettlementPeriodLeverageSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodLeverageBuilder extends SettlementPeriodLeverage, RosettaModelObjectBuilder {
		SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder getOrCreateSettlementPeriodLeverageSequence();
		SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder getSettlementPeriodLeverageSequence();
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setRatio(BigDecimal ratio);
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setSettlementPeriodLeverageSequence(SettlementPeriodLeverageSequence settlementPeriodLeverageSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ratio"), BigDecimal.class, getRatio(), this);
			processRosetta(path.newSubPath("settlementPeriodLeverageSequence"), processor, SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder.class, getSettlementPeriodLeverageSequence());
		}
		

		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodLeverage  ***********************/
	class SettlementPeriodLeverageImpl implements SettlementPeriodLeverage {
		private final BigDecimal ratio;
		private final SettlementPeriodLeverageSequence settlementPeriodLeverageSequence;
		
		protected SettlementPeriodLeverageImpl(SettlementPeriodLeverage.SettlementPeriodLeverageBuilder builder) {
			this.ratio = builder.getRatio();
			this.settlementPeriodLeverageSequence = ofNullable(builder.getSettlementPeriodLeverageSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ratio")
		public BigDecimal getRatio() {
			return ratio;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodLeverageSequence")
		public SettlementPeriodLeverageSequence getSettlementPeriodLeverageSequence() {
			return settlementPeriodLeverageSequence;
		}
		
		@Override
		public SettlementPeriodLeverage build() {
			return this;
		}
		
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder toBuilder() {
			SettlementPeriodLeverage.SettlementPeriodLeverageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodLeverage.SettlementPeriodLeverageBuilder builder) {
			ofNullable(getRatio()).ifPresent(builder::setRatio);
			ofNullable(getSettlementPeriodLeverageSequence()).ifPresent(builder::setSettlementPeriodLeverageSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodLeverage _that = getType().cast(o);
		
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(settlementPeriodLeverageSequence, _that.getSettlementPeriodLeverageSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodLeverageSequence != null ? settlementPeriodLeverageSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodLeverage {" +
				"ratio=" + this.ratio + ", " +
				"settlementPeriodLeverageSequence=" + this.settlementPeriodLeverageSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriodLeverage  ***********************/
	class SettlementPeriodLeverageBuilderImpl implements SettlementPeriodLeverage.SettlementPeriodLeverageBuilder {
	
		protected BigDecimal ratio;
		protected SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder settlementPeriodLeverageSequence;
	
		public SettlementPeriodLeverageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("ratio")
		public BigDecimal getRatio() {
			return ratio;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodLeverageSequence")
		public SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder getSettlementPeriodLeverageSequence() {
			return settlementPeriodLeverageSequence;
		}
		
		@Override
		public SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder getOrCreateSettlementPeriodLeverageSequence() {
			SettlementPeriodLeverageSequence.SettlementPeriodLeverageSequenceBuilder result;
			if (settlementPeriodLeverageSequence!=null) {
				result = settlementPeriodLeverageSequence;
			}
			else {
				result = settlementPeriodLeverageSequence = SettlementPeriodLeverageSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ratio")
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setRatio(BigDecimal ratio) {
			this.ratio = ratio==null?null:ratio;
			return this;
		}
		@Override
		@RosettaAttribute("settlementPeriodLeverageSequence")
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setSettlementPeriodLeverageSequence(SettlementPeriodLeverageSequence settlementPeriodLeverageSequence) {
			this.settlementPeriodLeverageSequence = settlementPeriodLeverageSequence==null?null:settlementPeriodLeverageSequence.toBuilder();
			return this;
		}
		
		@Override
		public SettlementPeriodLeverage build() {
			return new SettlementPeriodLeverage.SettlementPeriodLeverageImpl(this);
		}
		
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder prune() {
			if (settlementPeriodLeverageSequence!=null && !settlementPeriodLeverageSequence.prune().hasData()) settlementPeriodLeverageSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRatio()!=null) return true;
			if (getSettlementPeriodLeverageSequence()!=null && getSettlementPeriodLeverageSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriodLeverage.SettlementPeriodLeverageBuilder o = (SettlementPeriodLeverage.SettlementPeriodLeverageBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodLeverageSequence(), o.getSettlementPeriodLeverageSequence(), this::setSettlementPeriodLeverageSequence);
			
			merger.mergeBasic(getRatio(), o.getRatio(), this::setRatio);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodLeverage _that = getType().cast(o);
		
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(settlementPeriodLeverageSequence, _that.getSettlementPeriodLeverageSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodLeverageSequence != null ? settlementPeriodLeverageSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodLeverageBuilder {" +
				"ratio=" + this.ratio + ", " +
				"settlementPeriodLeverageSequence=" + this.settlementPeriodLeverageSequence +
			'}';
		}
	}
}
