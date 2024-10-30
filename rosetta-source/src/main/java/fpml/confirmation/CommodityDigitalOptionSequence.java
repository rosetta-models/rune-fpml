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
import fpml.confirmation.CommodityDigitalOptionSequence;
import fpml.confirmation.CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder;
import fpml.confirmation.CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilderImpl;
import fpml.confirmation.CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceImpl;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.meta.CommodityDigitalOptionSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityDigitalOptionSequence", builder=CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityDigitalOptionSequence extends RosettaModelObject {

	CommodityDigitalOptionSequenceMeta metaData = new CommodityDigitalOptionSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The volume contracted when the volume is specified as a quantity of commodity.
	 */
	CommodityNotionalQuantity getNotionalQuantity();
	BigDecimal getTotalNotionalQuantity();

	/*********************** Build Methods  ***********************/
	CommodityDigitalOptionSequence build();
	
	CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder toBuilder();
	
	static CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder builder() {
		return new CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDigitalOptionSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDigitalOptionSequence> getType() {
		return CommodityDigitalOptionSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.class, getNotionalQuantity());
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDigitalOptionSequenceBuilder extends CommodityDigitalOptionSequence, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getNotionalQuantity();
		CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity);
		CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalQuantity());
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		}
		

		CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDigitalOptionSequence  ***********************/
	class CommodityDigitalOptionSequenceImpl implements CommodityDigitalOptionSequence {
		private final CommodityNotionalQuantity notionalQuantity;
		private final BigDecimal totalNotionalQuantity;
		
		protected CommodityDigitalOptionSequenceImpl(CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder builder) {
			this.notionalQuantity = ofNullable(builder.getNotionalQuantity()).map(f->f.build()).orElse(null);
			this.totalNotionalQuantity = builder.getTotalNotionalQuantity();
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		public CommodityNotionalQuantity getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		public CommodityDigitalOptionSequence build() {
			return this;
		}
		
		@Override
		public CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder toBuilder() {
			CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder builder) {
			ofNullable(getNotionalQuantity()).ifPresent(builder::setNotionalQuantity);
			ofNullable(getTotalNotionalQuantity()).ifPresent(builder::setTotalNotionalQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigitalOptionSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalOptionSequence {" +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDigitalOptionSequence  ***********************/
	class CommodityDigitalOptionSequenceBuilderImpl implements CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder {
	
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder notionalQuantity;
		protected BigDecimal totalNotionalQuantity;
	
		public CommodityDigitalOptionSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (notionalQuantity!=null) {
				result = notionalQuantity;
			}
			else {
				result = notionalQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		public CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity) {
			this.notionalQuantity = notionalQuantity==null?null:notionalQuantity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		public CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity) {
			this.totalNotionalQuantity = totalNotionalQuantity==null?null:totalNotionalQuantity;
			return this;
		}
		
		@Override
		public CommodityDigitalOptionSequence build() {
			return new CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceImpl(this);
		}
		
		@Override
		public CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder prune() {
			if (notionalQuantity!=null && !notionalQuantity.prune().hasData()) notionalQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalQuantity()!=null && getNotionalQuantity().hasData()) return true;
			if (getTotalNotionalQuantity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder o = (CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder) other;
			
			merger.mergeRosetta(getNotionalQuantity(), o.getNotionalQuantity(), this::setNotionalQuantity);
			
			merger.mergeBasic(getTotalNotionalQuantity(), o.getTotalNotionalQuantity(), this::setTotalNotionalQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigitalOptionSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalOptionSequenceBuilder {" +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity +
			'}';
		}
	}
}
