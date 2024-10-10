package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditEventNoticeType;
import fpml.confirmation.validation.CreditEventNoticeTypeTypeFormatValidator;
import fpml.confirmation.validation.CreditEventNoticeTypeValidator;
import fpml.confirmation.validation.exists.CreditEventNoticeTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditEventNoticeType.class)
public class CreditEventNoticeTypeMeta implements RosettaMetaData<CreditEventNoticeType> {

	@Override
	public List<Validator<? super CreditEventNoticeType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventNoticeType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditEventNoticeType> validator() {
		return new CreditEventNoticeTypeValidator();
	}

	@Override
	public Validator<? super CreditEventNoticeType> typeFormatValidator() {
		return new CreditEventNoticeTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventNoticeType, Set<String>> onlyExistsValidator() {
		return new CreditEventNoticeTypeOnlyExistsValidator();
	}
}
