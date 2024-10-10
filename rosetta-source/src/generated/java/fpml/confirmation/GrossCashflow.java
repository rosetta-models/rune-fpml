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
import fpml.confirmation.CashflowType;
import fpml.confirmation.GrossCashflow;
import fpml.confirmation.GrossCashflow.GrossCashflowBuilder;
import fpml.confirmation.GrossCashflow.GrossCashflowBuilderImpl;
import fpml.confirmation.GrossCashflow.GrossCashflowImpl;
import fpml.confirmation.GrossCashflowSequence;
import fpml.confirmation.meta.GrossCashflowMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A payment component owed from one party to the other for the cash flow date. This payment component should by of only a single type, e.g. a fee or a cashflow from a cashflow stream.
 * @version ${project.version}
 */
@RosettaDataType(value="GrossCashflow", builder=GrossCashflow.GrossCashflowBuilderImpl.class, version="${project.version}")
public interface GrossCashflow extends RosettaModelObject {

	GrossCashflowMeta metaData = new GrossCashflowMeta();

	/*********************** Getter Methods  ***********************/
	GrossCashflowSequence getGrossCashflowSequence();
	/**
	 * Defines the type of cash flow. For instance, a type of fee, premium, principal exchange, leg fee.
	 */
	CashflowType getCashflowType();

	/*********************** Build Methods  ***********************/
	GrossCashflow build();
	
	GrossCashflow.GrossCashflowBuilder toBuilder();
	
	static GrossCashflow.GrossCashflowBuilder builder() {
		return new GrossCashflow.GrossCashflowBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GrossCashflow> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GrossCashflow> getType() {
		return GrossCashflow.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("grossCashflowSequence"), processor, GrossCashflowSequence.class, getGrossCashflowSequence());
		processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.class, getCashflowType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GrossCashflowBuilder extends GrossCashflow, RosettaModelObjectBuilder {
		GrossCashflowSequence.GrossCashflowSequenceBuilder getOrCreateGrossCashflowSequence();
		GrossCashflowSequence.GrossCashflowSequenceBuilder getGrossCashflowSequence();
		CashflowType.CashflowTypeBuilder getOrCreateCashflowType();
		CashflowType.CashflowTypeBuilder getCashflowType();
		GrossCashflow.GrossCashflowBuilder setGrossCashflowSequence(GrossCashflowSequence grossCashflowSequence);
		GrossCashflow.GrossCashflowBuilder setCashflowType(CashflowType cashflowType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("grossCashflowSequence"), processor, GrossCashflowSequence.GrossCashflowSequenceBuilder.class, getGrossCashflowSequence());
			processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.CashflowTypeBuilder.class, getCashflowType());
		}
		

		GrossCashflow.GrossCashflowBuilder prune();
	}

	/*********************** Immutable Implementation of GrossCashflow  ***********************/
	class GrossCashflowImpl implements GrossCashflow {
		private final GrossCashflowSequence grossCashflowSequence;
		private final CashflowType cashflowType;
		
		protected GrossCashflowImpl(GrossCashflow.GrossCashflowBuilder builder) {
			this.grossCashflowSequence = ofNullable(builder.getGrossCashflowSequence()).map(f->f.build()).orElse(null);
			this.cashflowType = ofNullable(builder.getCashflowType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("grossCashflowSequence")
		public GrossCashflowSequence getGrossCashflowSequence() {
			return grossCashflowSequence;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		public CashflowType getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public GrossCashflow build() {
			return this;
		}
		
		@Override
		public GrossCashflow.GrossCashflowBuilder toBuilder() {
			GrossCashflow.GrossCashflowBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GrossCashflow.GrossCashflowBuilder builder) {
			ofNullable(getGrossCashflowSequence()).ifPresent(builder::setGrossCashflowSequence);
			ofNullable(getCashflowType()).ifPresent(builder::setCashflowType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GrossCashflow _that = getType().cast(o);
		
			if (!Objects.equals(grossCashflowSequence, _that.getGrossCashflowSequence())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grossCashflowSequence != null ? grossCashflowSequence.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GrossCashflow {" +
				"grossCashflowSequence=" + this.grossCashflowSequence + ", " +
				"cashflowType=" + this.cashflowType +
			'}';
		}
	}

	/*********************** Builder Implementation of GrossCashflow  ***********************/
	class GrossCashflowBuilderImpl implements GrossCashflow.GrossCashflowBuilder {
	
		protected GrossCashflowSequence.GrossCashflowSequenceBuilder grossCashflowSequence;
		protected CashflowType.CashflowTypeBuilder cashflowType;
	
		public GrossCashflowBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("grossCashflowSequence")
		public GrossCashflowSequence.GrossCashflowSequenceBuilder getGrossCashflowSequence() {
			return grossCashflowSequence;
		}
		
		@Override
		public GrossCashflowSequence.GrossCashflowSequenceBuilder getOrCreateGrossCashflowSequence() {
			GrossCashflowSequence.GrossCashflowSequenceBuilder result;
			if (grossCashflowSequence!=null) {
				result = grossCashflowSequence;
			}
			else {
				result = grossCashflowSequence = GrossCashflowSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		public CashflowType.CashflowTypeBuilder getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public CashflowType.CashflowTypeBuilder getOrCreateCashflowType() {
			CashflowType.CashflowTypeBuilder result;
			if (cashflowType!=null) {
				result = cashflowType;
			}
			else {
				result = cashflowType = CashflowType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grossCashflowSequence")
		public GrossCashflow.GrossCashflowBuilder setGrossCashflowSequence(GrossCashflowSequence grossCashflowSequence) {
			this.grossCashflowSequence = grossCashflowSequence==null?null:grossCashflowSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashflowType")
		public GrossCashflow.GrossCashflowBuilder setCashflowType(CashflowType cashflowType) {
			this.cashflowType = cashflowType==null?null:cashflowType.toBuilder();
			return this;
		}
		
		@Override
		public GrossCashflow build() {
			return new GrossCashflow.GrossCashflowImpl(this);
		}
		
		@Override
		public GrossCashflow.GrossCashflowBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GrossCashflow.GrossCashflowBuilder prune() {
			if (grossCashflowSequence!=null && !grossCashflowSequence.prune().hasData()) grossCashflowSequence = null;
			if (cashflowType!=null && !cashflowType.prune().hasData()) cashflowType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGrossCashflowSequence()!=null && getGrossCashflowSequence().hasData()) return true;
			if (getCashflowType()!=null && getCashflowType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GrossCashflow.GrossCashflowBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GrossCashflow.GrossCashflowBuilder o = (GrossCashflow.GrossCashflowBuilder) other;
			
			merger.mergeRosetta(getGrossCashflowSequence(), o.getGrossCashflowSequence(), this::setGrossCashflowSequence);
			merger.mergeRosetta(getCashflowType(), o.getCashflowType(), this::setCashflowType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GrossCashflow _that = getType().cast(o);
		
			if (!Objects.equals(grossCashflowSequence, _that.getGrossCashflowSequence())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grossCashflowSequence != null ? grossCashflowSequence.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GrossCashflowBuilder {" +
				"grossCashflowSequence=" + this.grossCashflowSequence + ", " +
				"cashflowType=" + this.cashflowType +
			'}';
		}
	}
}
