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
import fpml.confirmation.ReferenceLevel;
import fpml.confirmation.ReferenceLevel.ReferenceLevelBuilder;
import fpml.confirmation.ReferenceLevel.ReferenceLevelBuilderImpl;
import fpml.confirmation.ReferenceLevel.ReferenceLevelImpl;
import fpml.confirmation.ReferenceLevelUnit;
import fpml.confirmation.meta.ReferenceLevelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReferenceLevel", builder=ReferenceLevel.ReferenceLevelBuilderImpl.class, version="${project.version}")
public interface ReferenceLevel extends RosettaModelObject {

	ReferenceLevelMeta metaData = new ReferenceLevelMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getAmount();
	ReferenceLevelUnit getReferenceLevelUnit();

	/*********************** Build Methods  ***********************/
	ReferenceLevel build();
	
	ReferenceLevel.ReferenceLevelBuilder toBuilder();
	
	static ReferenceLevel.ReferenceLevelBuilder builder() {
		return new ReferenceLevel.ReferenceLevelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceLevel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferenceLevel> getType() {
		return ReferenceLevel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processRosetta(path.newSubPath("referenceLevelUnit"), processor, ReferenceLevelUnit.class, getReferenceLevelUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceLevelBuilder extends ReferenceLevel, RosettaModelObjectBuilder {
		ReferenceLevelUnit.ReferenceLevelUnitBuilder getOrCreateReferenceLevelUnit();
		ReferenceLevelUnit.ReferenceLevelUnitBuilder getReferenceLevelUnit();
		ReferenceLevel.ReferenceLevelBuilder setAmount(BigDecimal amount);
		ReferenceLevel.ReferenceLevelBuilder setReferenceLevelUnit(ReferenceLevelUnit referenceLevelUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processRosetta(path.newSubPath("referenceLevelUnit"), processor, ReferenceLevelUnit.ReferenceLevelUnitBuilder.class, getReferenceLevelUnit());
		}
		

		ReferenceLevel.ReferenceLevelBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceLevel  ***********************/
	class ReferenceLevelImpl implements ReferenceLevel {
		private final BigDecimal amount;
		private final ReferenceLevelUnit referenceLevelUnit;
		
		protected ReferenceLevelImpl(ReferenceLevel.ReferenceLevelBuilder builder) {
			this.amount = builder.getAmount();
			this.referenceLevelUnit = ofNullable(builder.getReferenceLevelUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("referenceLevelUnit")
		public ReferenceLevelUnit getReferenceLevelUnit() {
			return referenceLevelUnit;
		}
		
		@Override
		public ReferenceLevel build() {
			return this;
		}
		
		@Override
		public ReferenceLevel.ReferenceLevelBuilder toBuilder() {
			ReferenceLevel.ReferenceLevelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceLevel.ReferenceLevelBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getReferenceLevelUnit()).ifPresent(builder::setReferenceLevelUnit);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceLevel _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(referenceLevelUnit, _that.getReferenceLevelUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (referenceLevelUnit != null ? referenceLevelUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceLevel {" +
				"amount=" + this.amount + ", " +
				"referenceLevelUnit=" + this.referenceLevelUnit +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceLevel  ***********************/
	class ReferenceLevelBuilderImpl implements ReferenceLevel.ReferenceLevelBuilder {
	
		protected BigDecimal amount;
		protected ReferenceLevelUnit.ReferenceLevelUnitBuilder referenceLevelUnit;
	
		public ReferenceLevelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("referenceLevelUnit")
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder getReferenceLevelUnit() {
			return referenceLevelUnit;
		}
		
		@Override
		public ReferenceLevelUnit.ReferenceLevelUnitBuilder getOrCreateReferenceLevelUnit() {
			ReferenceLevelUnit.ReferenceLevelUnitBuilder result;
			if (referenceLevelUnit!=null) {
				result = referenceLevelUnit;
			}
			else {
				result = referenceLevelUnit = ReferenceLevelUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public ReferenceLevel.ReferenceLevelBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		@RosettaAttribute("referenceLevelUnit")
		public ReferenceLevel.ReferenceLevelBuilder setReferenceLevelUnit(ReferenceLevelUnit referenceLevelUnit) {
			this.referenceLevelUnit = referenceLevelUnit==null?null:referenceLevelUnit.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceLevel build() {
			return new ReferenceLevel.ReferenceLevelImpl(this);
		}
		
		@Override
		public ReferenceLevel.ReferenceLevelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceLevel.ReferenceLevelBuilder prune() {
			if (referenceLevelUnit!=null && !referenceLevelUnit.prune().hasData()) referenceLevelUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null) return true;
			if (getReferenceLevelUnit()!=null && getReferenceLevelUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceLevel.ReferenceLevelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceLevel.ReferenceLevelBuilder o = (ReferenceLevel.ReferenceLevelBuilder) other;
			
			merger.mergeRosetta(getReferenceLevelUnit(), o.getReferenceLevelUnit(), this::setReferenceLevelUnit);
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceLevel _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(referenceLevelUnit, _that.getReferenceLevelUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (referenceLevelUnit != null ? referenceLevelUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceLevelBuilder {" +
				"amount=" + this.amount + ", " +
				"referenceLevelUnit=" + this.referenceLevelUnit +
			'}';
		}
	}
}
