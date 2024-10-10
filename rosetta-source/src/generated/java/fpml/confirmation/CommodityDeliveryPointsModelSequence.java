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
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.CommodityDeliveryPointsModelSequence;
import fpml.confirmation.CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder;
import fpml.confirmation.CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilderImpl;
import fpml.confirmation.CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceImpl;
import fpml.confirmation.meta.CommodityDeliveryPointsModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityDeliveryPointsModelSequence", builder=CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityDeliveryPointsModelSequence extends RosettaModelObject {

	CommodityDeliveryPointsModelSequenceMeta metaData = new CommodityDeliveryPointsModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The physical or virtual point at which the commodity enters a transportation system.
	 */
	CommodityDeliveryPoint getEntryPoint();
	/**
	 * The physical or virtual point at which the commodity is withdrawn from a transportation system.
	 */
	CommodityDeliveryPoint getWithdrawalPoint();

	/*********************** Build Methods  ***********************/
	CommodityDeliveryPointsModelSequence build();
	
	CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder toBuilder();
	
	static CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder builder() {
		return new CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDeliveryPointsModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDeliveryPointsModelSequence> getType() {
		return CommodityDeliveryPointsModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("entryPoint"), processor, CommodityDeliveryPoint.class, getEntryPoint());
		processRosetta(path.newSubPath("withdrawalPoint"), processor, CommodityDeliveryPoint.class, getWithdrawalPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDeliveryPointsModelSequenceBuilder extends CommodityDeliveryPointsModelSequence, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateEntryPoint();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getEntryPoint();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateWithdrawalPoint();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getWithdrawalPoint();
		CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder setEntryPoint(CommodityDeliveryPoint entryPoint);
		CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder setWithdrawalPoint(CommodityDeliveryPoint withdrawalPoint);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("entryPoint"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getEntryPoint());
			processRosetta(path.newSubPath("withdrawalPoint"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getWithdrawalPoint());
		}
		

		CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDeliveryPointsModelSequence  ***********************/
	class CommodityDeliveryPointsModelSequenceImpl implements CommodityDeliveryPointsModelSequence {
		private final CommodityDeliveryPoint entryPoint;
		private final CommodityDeliveryPoint withdrawalPoint;
		
		protected CommodityDeliveryPointsModelSequenceImpl(CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder builder) {
			this.entryPoint = ofNullable(builder.getEntryPoint()).map(f->f.build()).orElse(null);
			this.withdrawalPoint = ofNullable(builder.getWithdrawalPoint()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("entryPoint")
		public CommodityDeliveryPoint getEntryPoint() {
			return entryPoint;
		}
		
		@Override
		@RosettaAttribute("withdrawalPoint")
		public CommodityDeliveryPoint getWithdrawalPoint() {
			return withdrawalPoint;
		}
		
		@Override
		public CommodityDeliveryPointsModelSequence build() {
			return this;
		}
		
		@Override
		public CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder toBuilder() {
			CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder builder) {
			ofNullable(getEntryPoint()).ifPresent(builder::setEntryPoint);
			ofNullable(getWithdrawalPoint()).ifPresent(builder::setWithdrawalPoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPointsModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(entryPoint, _that.getEntryPoint())) return false;
			if (!Objects.equals(withdrawalPoint, _that.getWithdrawalPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entryPoint != null ? entryPoint.hashCode() : 0);
			_result = 31 * _result + (withdrawalPoint != null ? withdrawalPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPointsModelSequence {" +
				"entryPoint=" + this.entryPoint + ", " +
				"withdrawalPoint=" + this.withdrawalPoint +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDeliveryPointsModelSequence  ***********************/
	class CommodityDeliveryPointsModelSequenceBuilderImpl implements CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder {
	
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder entryPoint;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder withdrawalPoint;
	
		public CommodityDeliveryPointsModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("entryPoint")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getEntryPoint() {
			return entryPoint;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateEntryPoint() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (entryPoint!=null) {
				result = entryPoint;
			}
			else {
				result = entryPoint = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("withdrawalPoint")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getWithdrawalPoint() {
			return withdrawalPoint;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateWithdrawalPoint() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (withdrawalPoint!=null) {
				result = withdrawalPoint;
			}
			else {
				result = withdrawalPoint = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("entryPoint")
		public CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder setEntryPoint(CommodityDeliveryPoint entryPoint) {
			this.entryPoint = entryPoint==null?null:entryPoint.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("withdrawalPoint")
		public CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder setWithdrawalPoint(CommodityDeliveryPoint withdrawalPoint) {
			this.withdrawalPoint = withdrawalPoint==null?null:withdrawalPoint.toBuilder();
			return this;
		}
		
		@Override
		public CommodityDeliveryPointsModelSequence build() {
			return new CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceImpl(this);
		}
		
		@Override
		public CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder prune() {
			if (entryPoint!=null && !entryPoint.prune().hasData()) entryPoint = null;
			if (withdrawalPoint!=null && !withdrawalPoint.prune().hasData()) withdrawalPoint = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEntryPoint()!=null && getEntryPoint().hasData()) return true;
			if (getWithdrawalPoint()!=null && getWithdrawalPoint().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder o = (CommodityDeliveryPointsModelSequence.CommodityDeliveryPointsModelSequenceBuilder) other;
			
			merger.mergeRosetta(getEntryPoint(), o.getEntryPoint(), this::setEntryPoint);
			merger.mergeRosetta(getWithdrawalPoint(), o.getWithdrawalPoint(), this::setWithdrawalPoint);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPointsModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(entryPoint, _that.getEntryPoint())) return false;
			if (!Objects.equals(withdrawalPoint, _that.getWithdrawalPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entryPoint != null ? entryPoint.hashCode() : 0);
			_result = 31 * _result + (withdrawalPoint != null ? withdrawalPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPointsModelSequenceBuilder {" +
				"entryPoint=" + this.entryPoint + ", " +
				"withdrawalPoint=" + this.withdrawalPoint +
			'}';
		}
	}
}
