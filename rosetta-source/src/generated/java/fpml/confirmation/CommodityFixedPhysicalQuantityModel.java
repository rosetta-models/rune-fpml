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
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilderImpl;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelImpl;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityPhysicalQuantitySchedule;
import fpml.confirmation.UnitQuantity;
import fpml.confirmation.meta.CommodityFixedPhysicalQuantityModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying a fixed physical quantity of commodity to be delivered.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityFixedPhysicalQuantityModel", builder=CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilderImpl.class, version="${project.version}")
public interface CommodityFixedPhysicalQuantityModel extends RosettaModelObject {

	CommodityFixedPhysicalQuantityModelMeta metaData = new CommodityFixedPhysicalQuantityModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Quantity per Delivery Period.
	 */
	CommodityNotionalQuantity getPhysicalQuantity();
	/**
	 * Allows the documentation of a shaped quantity trade where the quantity changes over the life of the transaction.
	 */
	CommodityPhysicalQuantitySchedule getPhysicalQuantitySchedule();
	/**
	 * The Total Quantity of the commodity to be delivered.
	 */
	UnitQuantity getTotalPhysicalQuantity();

	/*********************** Build Methods  ***********************/
	CommodityFixedPhysicalQuantityModel build();
	
	CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder toBuilder();
	
	static CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder builder() {
		return new CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFixedPhysicalQuantityModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFixedPhysicalQuantityModel> getType() {
		return CommodityFixedPhysicalQuantityModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.class, getPhysicalQuantity());
		processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.class, getPhysicalQuantitySchedule());
		processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.class, getTotalPhysicalQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFixedPhysicalQuantityModelBuilder extends CommodityFixedPhysicalQuantityModel, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreatePhysicalQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getPhysicalQuantity();
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule();
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getPhysicalQuantitySchedule();
		UnitQuantity.UnitQuantityBuilder getOrCreateTotalPhysicalQuantity();
		UnitQuantity.UnitQuantityBuilder getTotalPhysicalQuantity();
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder setPhysicalQuantity(CommodityNotionalQuantity physicalQuantity);
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule physicalQuantitySchedule);
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder setTotalPhysicalQuantity(UnitQuantity totalPhysicalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getPhysicalQuantity());
			processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder.class, getPhysicalQuantitySchedule());
			processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.UnitQuantityBuilder.class, getTotalPhysicalQuantity());
		}
		

		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFixedPhysicalQuantityModel  ***********************/
	class CommodityFixedPhysicalQuantityModelImpl implements CommodityFixedPhysicalQuantityModel {
		private final CommodityNotionalQuantity physicalQuantity;
		private final CommodityPhysicalQuantitySchedule physicalQuantitySchedule;
		private final UnitQuantity totalPhysicalQuantity;
		
		protected CommodityFixedPhysicalQuantityModelImpl(CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder builder) {
			this.physicalQuantity = ofNullable(builder.getPhysicalQuantity()).map(f->f.build()).orElse(null);
			this.physicalQuantitySchedule = ofNullable(builder.getPhysicalQuantitySchedule()).map(f->f.build()).orElse(null);
			this.totalPhysicalQuantity = ofNullable(builder.getTotalPhysicalQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("physicalQuantity")
		public CommodityNotionalQuantity getPhysicalQuantity() {
			return physicalQuantity;
		}
		
		@Override
		@RosettaAttribute("physicalQuantitySchedule")
		public CommodityPhysicalQuantitySchedule getPhysicalQuantitySchedule() {
			return physicalQuantitySchedule;
		}
		
		@Override
		@RosettaAttribute("totalPhysicalQuantity")
		public UnitQuantity getTotalPhysicalQuantity() {
			return totalPhysicalQuantity;
		}
		
		@Override
		public CommodityFixedPhysicalQuantityModel build() {
			return this;
		}
		
		@Override
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder toBuilder() {
			CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder builder) {
			ofNullable(getPhysicalQuantity()).ifPresent(builder::setPhysicalQuantity);
			ofNullable(getPhysicalQuantitySchedule()).ifPresent(builder::setPhysicalQuantitySchedule);
			ofNullable(getTotalPhysicalQuantity()).ifPresent(builder::setTotalPhysicalQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPhysicalQuantityModel _that = getType().cast(o);
		
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPhysicalQuantityModel {" +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFixedPhysicalQuantityModel  ***********************/
	class CommodityFixedPhysicalQuantityModelBuilderImpl implements CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder {
	
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder physicalQuantity;
		protected CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder physicalQuantitySchedule;
		protected UnitQuantity.UnitQuantityBuilder totalPhysicalQuantity;
	
		public CommodityFixedPhysicalQuantityModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("physicalQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getPhysicalQuantity() {
			return physicalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreatePhysicalQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (physicalQuantity!=null) {
				result = physicalQuantity;
			}
			else {
				result = physicalQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalQuantitySchedule")
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getPhysicalQuantitySchedule() {
			return physicalQuantitySchedule;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule() {
			CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder result;
			if (physicalQuantitySchedule!=null) {
				result = physicalQuantitySchedule;
			}
			else {
				result = physicalQuantitySchedule = CommodityPhysicalQuantitySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalPhysicalQuantity")
		public UnitQuantity.UnitQuantityBuilder getTotalPhysicalQuantity() {
			return totalPhysicalQuantity;
		}
		
		@Override
		public UnitQuantity.UnitQuantityBuilder getOrCreateTotalPhysicalQuantity() {
			UnitQuantity.UnitQuantityBuilder result;
			if (totalPhysicalQuantity!=null) {
				result = totalPhysicalQuantity;
			}
			else {
				result = totalPhysicalQuantity = UnitQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalQuantity")
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder setPhysicalQuantity(CommodityNotionalQuantity physicalQuantity) {
			this.physicalQuantity = physicalQuantity==null?null:physicalQuantity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("physicalQuantitySchedule")
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule physicalQuantitySchedule) {
			this.physicalQuantitySchedule = physicalQuantitySchedule==null?null:physicalQuantitySchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("totalPhysicalQuantity")
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder setTotalPhysicalQuantity(UnitQuantity totalPhysicalQuantity) {
			this.totalPhysicalQuantity = totalPhysicalQuantity==null?null:totalPhysicalQuantity.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFixedPhysicalQuantityModel build() {
			return new CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelImpl(this);
		}
		
		@Override
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder prune() {
			if (physicalQuantity!=null && !physicalQuantity.prune().hasData()) physicalQuantity = null;
			if (physicalQuantitySchedule!=null && !physicalQuantitySchedule.prune().hasData()) physicalQuantitySchedule = null;
			if (totalPhysicalQuantity!=null && !totalPhysicalQuantity.prune().hasData()) totalPhysicalQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPhysicalQuantity()!=null && getPhysicalQuantity().hasData()) return true;
			if (getPhysicalQuantitySchedule()!=null && getPhysicalQuantitySchedule().hasData()) return true;
			if (getTotalPhysicalQuantity()!=null && getTotalPhysicalQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder o = (CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder) other;
			
			merger.mergeRosetta(getPhysicalQuantity(), o.getPhysicalQuantity(), this::setPhysicalQuantity);
			merger.mergeRosetta(getPhysicalQuantitySchedule(), o.getPhysicalQuantitySchedule(), this::setPhysicalQuantitySchedule);
			merger.mergeRosetta(getTotalPhysicalQuantity(), o.getTotalPhysicalQuantity(), this::setTotalPhysicalQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPhysicalQuantityModel _that = getType().cast(o);
		
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPhysicalQuantityModelBuilder {" +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity +
			'}';
		}
	}
}
