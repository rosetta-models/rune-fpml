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
import fpml.confirmation.CommodityTriggerSequence;
import fpml.confirmation.CommodityTriggerSequence.CommodityTriggerSequenceBuilder;
import fpml.confirmation.CommodityTriggerSequence.CommodityTriggerSequenceBuilderImpl;
import fpml.confirmation.CommodityTriggerSequence.CommodityTriggerSequenceImpl;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.meta.CommodityTriggerSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityTriggerSequence", builder=CommodityTriggerSequence.CommodityTriggerSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityTriggerSequence extends RosettaModelObject {

	CommodityTriggerSequenceMeta metaData = new CommodityTriggerSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount used the specify the barrier in terms of an quantity of commodity or a change in the quantity of commodity. In confirmations this is often described as the &quot;Strike Volume&quot; or &quot;Strike Quantity&quot;.
	 */
	BigDecimal getLevelQuantity();
	/**
	 * The units (e.g. BCF) used to specify the barrier in terms of an quantity of commodity or change in the quantity of commodity.
	 */
	QuantityUnit getLevelUnit();

	/*********************** Build Methods  ***********************/
	CommodityTriggerSequence build();
	
	CommodityTriggerSequence.CommodityTriggerSequenceBuilder toBuilder();
	
	static CommodityTriggerSequence.CommodityTriggerSequenceBuilder builder() {
		return new CommodityTriggerSequence.CommodityTriggerSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityTriggerSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityTriggerSequence> getType() {
		return CommodityTriggerSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("levelQuantity"), BigDecimal.class, getLevelQuantity(), this);
		processRosetta(path.newSubPath("levelUnit"), processor, QuantityUnit.class, getLevelUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityTriggerSequenceBuilder extends CommodityTriggerSequence, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateLevelUnit();
		QuantityUnit.QuantityUnitBuilder getLevelUnit();
		CommodityTriggerSequence.CommodityTriggerSequenceBuilder setLevelQuantity(BigDecimal levelQuantity);
		CommodityTriggerSequence.CommodityTriggerSequenceBuilder setLevelUnit(QuantityUnit levelUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("levelQuantity"), BigDecimal.class, getLevelQuantity(), this);
			processRosetta(path.newSubPath("levelUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getLevelUnit());
		}
		

		CommodityTriggerSequence.CommodityTriggerSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityTriggerSequence  ***********************/
	class CommodityTriggerSequenceImpl implements CommodityTriggerSequence {
		private final BigDecimal levelQuantity;
		private final QuantityUnit levelUnit;
		
		protected CommodityTriggerSequenceImpl(CommodityTriggerSequence.CommodityTriggerSequenceBuilder builder) {
			this.levelQuantity = builder.getLevelQuantity();
			this.levelUnit = ofNullable(builder.getLevelUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("levelQuantity")
		public BigDecimal getLevelQuantity() {
			return levelQuantity;
		}
		
		@Override
		@RosettaAttribute("levelUnit")
		public QuantityUnit getLevelUnit() {
			return levelUnit;
		}
		
		@Override
		public CommodityTriggerSequence build() {
			return this;
		}
		
		@Override
		public CommodityTriggerSequence.CommodityTriggerSequenceBuilder toBuilder() {
			CommodityTriggerSequence.CommodityTriggerSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityTriggerSequence.CommodityTriggerSequenceBuilder builder) {
			ofNullable(getLevelQuantity()).ifPresent(builder::setLevelQuantity);
			ofNullable(getLevelUnit()).ifPresent(builder::setLevelUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityTriggerSequence _that = getType().cast(o);
		
			if (!Objects.equals(levelQuantity, _that.getLevelQuantity())) return false;
			if (!Objects.equals(levelUnit, _that.getLevelUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (levelQuantity != null ? levelQuantity.hashCode() : 0);
			_result = 31 * _result + (levelUnit != null ? levelUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTriggerSequence {" +
				"levelQuantity=" + this.levelQuantity + ", " +
				"levelUnit=" + this.levelUnit +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityTriggerSequence  ***********************/
	class CommodityTriggerSequenceBuilderImpl implements CommodityTriggerSequence.CommodityTriggerSequenceBuilder {
	
		protected BigDecimal levelQuantity;
		protected QuantityUnit.QuantityUnitBuilder levelUnit;
	
		public CommodityTriggerSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("levelQuantity")
		public BigDecimal getLevelQuantity() {
			return levelQuantity;
		}
		
		@Override
		@RosettaAttribute("levelUnit")
		public QuantityUnit.QuantityUnitBuilder getLevelUnit() {
			return levelUnit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateLevelUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (levelUnit!=null) {
				result = levelUnit;
			}
			else {
				result = levelUnit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("levelQuantity")
		public CommodityTriggerSequence.CommodityTriggerSequenceBuilder setLevelQuantity(BigDecimal levelQuantity) {
			this.levelQuantity = levelQuantity==null?null:levelQuantity;
			return this;
		}
		@Override
		@RosettaAttribute("levelUnit")
		public CommodityTriggerSequence.CommodityTriggerSequenceBuilder setLevelUnit(QuantityUnit levelUnit) {
			this.levelUnit = levelUnit==null?null:levelUnit.toBuilder();
			return this;
		}
		
		@Override
		public CommodityTriggerSequence build() {
			return new CommodityTriggerSequence.CommodityTriggerSequenceImpl(this);
		}
		
		@Override
		public CommodityTriggerSequence.CommodityTriggerSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTriggerSequence.CommodityTriggerSequenceBuilder prune() {
			if (levelUnit!=null && !levelUnit.prune().hasData()) levelUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLevelQuantity()!=null) return true;
			if (getLevelUnit()!=null && getLevelUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTriggerSequence.CommodityTriggerSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityTriggerSequence.CommodityTriggerSequenceBuilder o = (CommodityTriggerSequence.CommodityTriggerSequenceBuilder) other;
			
			merger.mergeRosetta(getLevelUnit(), o.getLevelUnit(), this::setLevelUnit);
			
			merger.mergeBasic(getLevelQuantity(), o.getLevelQuantity(), this::setLevelQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityTriggerSequence _that = getType().cast(o);
		
			if (!Objects.equals(levelQuantity, _that.getLevelQuantity())) return false;
			if (!Objects.equals(levelUnit, _that.getLevelUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (levelQuantity != null ? levelQuantity.hashCode() : 0);
			_result = 31 * _result + (levelUnit != null ? levelUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTriggerSequenceBuilder {" +
				"levelQuantity=" + this.levelQuantity + ", " +
				"levelUnit=" + this.levelUnit +
			'}';
		}
	}
}
