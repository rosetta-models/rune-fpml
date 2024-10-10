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
import fpml.confirmation.CommodityProductGrade;
import fpml.confirmation.OilProduct;
import fpml.confirmation.OilProduct.OilProductBuilder;
import fpml.confirmation.OilProduct.OilProductBuilderImpl;
import fpml.confirmation.OilProduct.OilProductImpl;
import fpml.confirmation.OilProductType;
import fpml.confirmation.meta.OilProductMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The specification of the oil product to be delivered.
 * @version ${project.version}
 */
@RosettaDataType(value="OilProduct", builder=OilProduct.OilProductBuilderImpl.class, version="${project.version}")
public interface OilProduct extends RosettaModelObject {

	OilProductMeta metaData = new OilProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of oil product to be delivered.
	 */
	OilProductType getType_();
	/**
	 * The grade of oil product to be delivered.
	 */
	CommodityProductGrade getGrade();

	/*********************** Build Methods  ***********************/
	OilProduct build();
	
	OilProduct.OilProductBuilder toBuilder();
	
	static OilProduct.OilProductBuilder builder() {
		return new OilProduct.OilProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilProduct> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OilProduct> getType() {
		return OilProduct.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, OilProductType.class, getType_());
		processRosetta(path.newSubPath("grade"), processor, CommodityProductGrade.class, getGrade());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilProductBuilder extends OilProduct, RosettaModelObjectBuilder {
		OilProductType.OilProductTypeBuilder getOrCreateType();
		OilProductType.OilProductTypeBuilder getType_();
		CommodityProductGrade.CommodityProductGradeBuilder getOrCreateGrade();
		CommodityProductGrade.CommodityProductGradeBuilder getGrade();
		OilProduct.OilProductBuilder setType(OilProductType type);
		OilProduct.OilProductBuilder setGrade(CommodityProductGrade grade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, OilProductType.OilProductTypeBuilder.class, getType_());
			processRosetta(path.newSubPath("grade"), processor, CommodityProductGrade.CommodityProductGradeBuilder.class, getGrade());
		}
		

		OilProduct.OilProductBuilder prune();
	}

	/*********************** Immutable Implementation of OilProduct  ***********************/
	class OilProductImpl implements OilProduct {
		private final OilProductType type;
		private final CommodityProductGrade grade;
		
		protected OilProductImpl(OilProduct.OilProductBuilder builder) {
			this.type = ofNullable(builder.getType_()).map(f->f.build()).orElse(null);
			this.grade = ofNullable(builder.getGrade()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		public OilProductType getType_() {
			return type;
		}
		
		@Override
		@RosettaAttribute("grade")
		public CommodityProductGrade getGrade() {
			return grade;
		}
		
		@Override
		public OilProduct build() {
			return this;
		}
		
		@Override
		public OilProduct.OilProductBuilder toBuilder() {
			OilProduct.OilProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilProduct.OilProductBuilder builder) {
			ofNullable(getType_()).ifPresent(builder::setType);
			ofNullable(getGrade()).ifPresent(builder::setGrade);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(grade, _that.getGrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilProduct {" +
				"type=" + this.type + ", " +
				"grade=" + this.grade +
			'}';
		}
	}

	/*********************** Builder Implementation of OilProduct  ***********************/
	class OilProductBuilderImpl implements OilProduct.OilProductBuilder {
	
		protected OilProductType.OilProductTypeBuilder type;
		protected CommodityProductGrade.CommodityProductGradeBuilder grade;
	
		public OilProductBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public OilProductType.OilProductTypeBuilder getType_() {
			return type;
		}
		
		@Override
		public OilProductType.OilProductTypeBuilder getOrCreateType() {
			OilProductType.OilProductTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = OilProductType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grade")
		public CommodityProductGrade.CommodityProductGradeBuilder getGrade() {
			return grade;
		}
		
		@Override
		public CommodityProductGrade.CommodityProductGradeBuilder getOrCreateGrade() {
			CommodityProductGrade.CommodityProductGradeBuilder result;
			if (grade!=null) {
				result = grade;
			}
			else {
				result = grade = CommodityProductGrade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		public OilProduct.OilProductBuilder setType(OilProductType type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("grade")
		public OilProduct.OilProductBuilder setGrade(CommodityProductGrade grade) {
			this.grade = grade==null?null:grade.toBuilder();
			return this;
		}
		
		@Override
		public OilProduct build() {
			return new OilProduct.OilProductImpl(this);
		}
		
		@Override
		public OilProduct.OilProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilProduct.OilProductBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			if (grade!=null && !grade.prune().hasData()) grade = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getType_()!=null && getType_().hasData()) return true;
			if (getGrade()!=null && getGrade().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilProduct.OilProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OilProduct.OilProductBuilder o = (OilProduct.OilProductBuilder) other;
			
			merger.mergeRosetta(getType_(), o.getType_(), this::setType);
			merger.mergeRosetta(getGrade(), o.getGrade(), this::setGrade);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(grade, _that.getGrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilProductBuilder {" +
				"type=" + this.type + ", " +
				"grade=" + this.grade +
			'}';
		}
	}
}
